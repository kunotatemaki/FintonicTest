package com.rukiasoft.fintonictest.sheroeslist.views

import android.arch.lifecycle.LifecycleObserver
import android.os.Bundle
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.FintonicApp
import com.rukiasoft.fintonictest.R
import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroListModule
import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserver
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenter
import com.rukiasoft.fintonictest.utils.ui.BaseActivity
import javax.inject.Inject


@CustomScopes.ActivityScope
class SuperHeroListActivity : BaseActivity(), SuperHeroListView {

    @Inject
    lateinit var presenter: SuperHeroListPresenter

    @Inject
    lateinit var observer: SuperHeroListLifecycleObserver

    @Inject
    lateinit var log: LoggerHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //region DEPENDENCY INJECTION
        (application as FintonicApp).mComponent.getSuperHeroListSubcomponent(SuperHeroListModule(this))
                .inject(this)
        //endregion
        setContentView(R.layout.activity_main)


    }


    //region SUPERHEROLISTVIEW INTERFACE
    override fun addLifecycleObserver(observer: SuperHeroListLifecycleObserver) {
        if(observer is LifecycleObserver){
            lifecycle.addObserver(observer)
        }
    }


    //endregion
}
