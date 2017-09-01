package com.rukiasoft.fintonictest.sherodetails.lifecycleobservers

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.safe
import com.rukiasoft.fintonictest.sherodetails.presenters.SuperHeroDetailPresenter
import com.rukiasoft.fintonictest.sherodetails.views.SuperHeroDetailView
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserver
import com.rukiasoft.fintonictest.sheroeslist.livedataobservers.MyLivedataObserver
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenter
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListView
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by Roll on 31/8/17.
 */
@CustomScopes.ActivityScope
class SuperHeroDetailLifecycleObserverAndroidImpl @Inject constructor(val mView: WeakReference<SuperHeroDetailView>)
    : SuperHeroDetailLifecycleObserver, LifecycleObserver {

    @Inject
    lateinit var presenter: SuperHeroDetailPresenter

    @Inject
    lateinit var log: LoggerHelper

    init {
        mView.safe{
            mView.get()!!.addLifecycleObserver(this@SuperHeroDetailLifecycleObserverAndroidImpl)
        }
    }





}