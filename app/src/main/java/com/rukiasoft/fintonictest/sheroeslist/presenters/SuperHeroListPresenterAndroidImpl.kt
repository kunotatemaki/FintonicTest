package com.rukiasoft.fintonictest.sheroeslist.presenters

import android.support.annotation.VisibleForTesting
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.R
import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.model.SuperHero
import com.rukiasoft.fintonictest.network.logic.NetworkManager
import com.rukiasoft.fintonictest.resources.ResourcesManager
import com.rukiasoft.fintonictest.safe
import com.rukiasoft.fintonictest.sheroeslist.livedataobservers.MyLivedataObserver
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListView
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroView
import java.lang.ref.WeakReference
import javax.inject.Inject
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType

/**
 * Created by Roll on 31/8/17.
 */
@CustomScopes.ActivityScope
class SuperHeroListPresenterAndroidImpl @Inject constructor(val mView: WeakReference<SuperHeroListView>)
    : SuperHeroListPresenter, MyLivedataObserver {

    @Inject
    lateinit var log: LoggerHelper

    @Inject
    lateinit var network: NetworkManager

    @Inject
    lateinit var resources: ResourcesManager

    @VisibleForTesting
    constructor(resources: ResourcesManager, log: LoggerHelper, mView: WeakReference<SuperHeroListView>,
                network: NetworkManager) : this(mView) {
        this.resources = resources
        this.log = log
        this.network = network

    }


    override fun loadSuperHeroes() {
        mView.safe {
            val myView = mView.get()!!

            if(myView.getLiveSuperHeroes().getLivedataValue()?.isEmpty() == false){
                //no hace falta forzar a la vista a cargar los datos de la caché, porque
                //el livedata notificará a su observador (this) de su último valor cuando se suscriba
                //así que se llamará a handle... y se actualizará ahí
                return@safe
            }else{
                mView.get()!!.showLoader()
                network.getSuperHeroes(myView.getLiveSuperHeroes())
            }
        }
    }

    override fun handleChangesInObservedSuperHeroes(superheroes: MutableList<SuperHero>) {
        mView.safe {
            val myView = mView.get()!!
            myView.hideLoader()
            if(superheroes.size == 0){
                myView.showEmptyList(resources.getString(R.string.no_superheroes))
            }else {
                mView.get()!!.setSuperHeroesInView(superheroes)
            }
        }
    }

    override fun superHeroClicked(superHeroView: SuperHeroView, superHero: SuperHero) {
        log.d(this, "pulsado: " + superHero.name)
        mView.safe {
            mView.get()!!.showSuperHeroDetails(superHeroView, superHero)
        }
    }
}