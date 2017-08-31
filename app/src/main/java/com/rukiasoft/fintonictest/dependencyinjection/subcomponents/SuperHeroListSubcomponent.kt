package com.rukiasoft.fintonictest.dependencyinjection.subcomponents

import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroListModule
import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListActivity
import dagger.Subcomponent

/**
 * Created by Roll on 31/8/17.
 */
@CustomScopes.ActivityScope
@Subcomponent(modules = arrayOf(SuperHeroListModule::class))
interface SuperHeroListSubcomponent {
    fun inject(activity: SuperHeroListActivity)
}

