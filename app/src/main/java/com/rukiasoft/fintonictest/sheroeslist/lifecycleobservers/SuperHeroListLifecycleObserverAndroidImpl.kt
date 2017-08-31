package com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.safe
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenter
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListView
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroListLifecycleObserverAndroidImpl @Inject constructor(val mView: WeakReference<SuperHeroListView>)
    : SuperHeroListLifecycleObserver, LifecycleObserver {

    @Inject
    lateinit var presenter: SuperHeroListPresenter

    @Inject
    lateinit var log: LoggerHelper

    init {
        mView.safe({
            mView.get()!!.addLifecycleObserver(this@SuperHeroListLifecycleObserverAndroidImpl)
        })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun actionInOnCreate() {
        log.d(this, "observer's oncreate")

        //force presenter to observe data (repos and user)
        /*if (presenter is LivedataObserver) {
            mView.getLiveAccounts().addObserverToLivedata(mView, presenter as LivedataObserver)
        }*/
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun actionInOnResume() {
        log.d(this, "observer's onstart")
        //presenter.loadAccounts()
    }



}