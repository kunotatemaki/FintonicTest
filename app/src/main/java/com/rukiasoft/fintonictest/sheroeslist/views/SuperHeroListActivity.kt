package com.rukiasoft.fintonictest.sheroeslist.views

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.FintonicApp
import com.rukiasoft.fintonictest.R
import com.rukiasoft.fintonictest.databinding.ActivityMainBinding
import com.rukiasoft.fintonictest.databinding.SuperheroItemBinding
import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroListModule
import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.model.SuperHero
import com.rukiasoft.fintonictest.sheroeslist.adapters.SuperHeroListAdapter
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserver
import com.rukiasoft.fintonictest.sheroeslist.presenters.SuperHeroListPresenter
import com.rukiasoft.fintonictest.sheroeslist.viewmodels.SuperHeroListViewModel
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

    @Inject
    protected lateinit var adapter: SuperHeroListAdapter

    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //region DEPENDENCY INJECTION
        (application as FintonicApp).mComponent.getSuperHeroListSubcomponent(SuperHeroListModule(this))
                .inject(this)
        //endregion


        //region DATA BINDING
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //endregion

        //set the mAdapter for the recycler view
        mRecyclerView = mBinding.superheroList

        // use a linear layout manager
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = adapter
        //add a divider decorator
        val dividerItemDecoration = DividerItemDecoration(mRecyclerView.context,
                DividerItemDecoration.VERTICAL)
        mRecyclerView.addItemDecoration(dividerItemDecoration)

    }


    //region SUPERHEROLISTVIEW INTERFACE
    override fun addLifecycleObserver(observer: SuperHeroListLifecycleObserver) {
        if(observer is LifecycleObserver){
            lifecycle.addObserver(observer)
        }
    }

    override fun getLiveSuperHeroes(): CustomLiveData<MutableList<SuperHero>> {
        return ViewModelProviders.of(this).get(SuperHeroListViewModel::class.java).superheroes
    }

    override fun setSuperHeroesInView(superHeroes: List<SuperHero>) {
        log.d(this, "show superheroes in view")
        adapter.superHeroes.clear()
        adapter.superHeroes.addAll(superHeroes)
        adapter.notifyDataSetChanged()
    }

    //endregion
}
