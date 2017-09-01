package com.rukiasoft.fintonictest.sherodetails.views

import android.arch.lifecycle.LifecycleObserver
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.MenuItem
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.FintonicApp
import com.rukiasoft.fintonictest.R
import com.rukiasoft.fintonictest.databinding.ActivitySuperHeroDetailBinding
import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroDetailModule
import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.model.SuperHero
import com.rukiasoft.fintonictest.sherodetails.lifecycleobservers.SuperHeroDetailLifecycleObserver
import com.rukiasoft.fintonictest.utils.FintonicConstants
import com.rukiasoft.fintonictest.utils.ui.BaseActivity
import com.rukiasoft.fintonictest.utils.ui.GlideBindingComponent
import kotlinx.android.synthetic.main.activity_super_hero_detail.*
import javax.inject.Inject

@CustomScopes.ActivityScope
class SuperHeroDetailActivity : BaseActivity(), SuperHeroDetailView {

    @Inject
    lateinit var log: LoggerHelper


    lateinit var mBinding: ActivitySuperHeroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //dependency injection
        (application as FintonicApp).mComponent
                .getSuperHeroDetailSubcomponent(SuperHeroDetailModule(this)).inject(this)

        //databinding
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_super_hero_detail, GlideBindingComponent())
        val superHero = intent.getParcelableExtra<SuperHero>(FintonicConstants.SUPERHERO)
        mBinding.superhero = superHero
        setToolbar(toolbar, true)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> {
                supportFinishAfterTransition()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun addLifecycleObserver(observer: SuperHeroDetailLifecycleObserver) {
        if(observer is LifecycleObserver){
            lifecycle.addObserver(observer)
        }
    }
}
