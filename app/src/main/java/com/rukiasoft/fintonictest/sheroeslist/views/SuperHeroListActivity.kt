package com.rukiasoft.fintonictest.sheroeslist.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.FintonicApp
import com.rukiasoft.fintonictest.R
import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroListModule
import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserver
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


@CustomScopes.ActivityScope
class SuperHeroListActivity : AppCompatActivity(), SuperHeroListView {

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

        setContentView(R.layout.activity_main)


    }
}
