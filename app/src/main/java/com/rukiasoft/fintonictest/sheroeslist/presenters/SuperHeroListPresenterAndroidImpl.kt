package com.rukiasoft.fintonictest.sheroeslist.presenters

import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.model.SuperHeroe
import com.rukiasoft.fintonictest.network.logic.NetworkManager
import com.rukiasoft.fintonictest.safe
import com.rukiasoft.fintonictest.sheroeslist.livedataobservers.MyLivedataObserver
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListView
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroListPresenterAndroidImpl @Inject constructor(val mView: WeakReference<SuperHeroListView>)
    : SuperHeroListPresenter, MyLivedataObserver {

    @Inject
    lateinit var log: LoggerHelper

    @Inject
    lateinit var network: NetworkManager


    override fun loadSuperHeroes() {
        mView.safe {
            val myView = mView.get()!!

            if(myView.getLiveSuperHeroes().getLivedataValue()?.isEmpty() == false){
                //no hace falta forzar a la vista a cargar los datos de la caché, porque
                //el livedata notificará a su observador (this) de su último valor cuando se suscriba
                //así que se llamará a handle... y se actualizará ahí
                return@safe
            }else{
                network.getSuperHeroes(myView.getLiveSuperHeroes())
            }
        }
    }

    override fun handleChangesInObservedSuperHeroes(superheroes: MutableList<SuperHeroe>) {
        mView.safe {
            mView.get()!!.setSuperHeroesInView(superheroes)
        }
    }

}