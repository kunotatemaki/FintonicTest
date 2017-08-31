package com.rukiasoft.fintonictest.sheroeslist.presenters

import android.arch.lifecycle.LifecycleObserver
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.model.SuperHeroe
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




    override fun handleChangesInObservedSuperHeroes(accounts: MutableList<SuperHeroe>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}