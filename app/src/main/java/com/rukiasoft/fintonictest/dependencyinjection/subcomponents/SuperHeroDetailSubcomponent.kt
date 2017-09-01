package com.rukiasoft.fintonictest.dependencyinjection.subcomponents

import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroDetailModule
import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroListModule
import com.rukiasoft.fintonictest.dependencyinjection.scopes.CustomScopes
import com.rukiasoft.fintonictest.sherodetails.views.SuperHeroDetailActivity
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroListActivity
import dagger.Subcomponent

/**
 * Created by Roll on 31/8/17.
 */
@CustomScopes.ActivityScope
@Subcomponent(modules = arrayOf(SuperHeroDetailModule::class))
interface SuperHeroDetailSubcomponent {
    fun inject(activity: SuperHeroDetailActivity)
}