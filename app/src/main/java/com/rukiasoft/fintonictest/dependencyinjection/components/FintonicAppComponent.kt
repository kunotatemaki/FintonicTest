package com.rukiasoft.fintonictest.dependencyinjection.components

import com.rukiasoft.fintonictest.dependencyinjection.modules.FintonicAppModule
import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroListModule
import com.rukiasoft.fintonictest.dependencyinjection.subcomponents.SuperHeroListSubcomponent
import dagger.Component

/**
 * Created by Roll on 31/8/17.
 */
@Component(modules = arrayOf(FintonicAppModule::class))
interface FintonicAppComponent {
    fun getSuperHeroListSubcomponent(module: SuperHeroListModule): SuperHeroListSubcomponent

}