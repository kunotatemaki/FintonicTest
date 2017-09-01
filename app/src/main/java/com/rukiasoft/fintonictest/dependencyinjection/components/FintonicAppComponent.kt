package com.rukiasoft.fintonictest.dependencyinjection.components

import com.rukiasoft.fintonictest.dependencyinjection.modules.FintonicAppModule
import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroDetailModule
import com.rukiasoft.fintonictest.dependencyinjection.modules.SuperHeroListModule
import com.rukiasoft.fintonictest.dependencyinjection.subcomponents.SuperHeroDetailSubcomponent
import com.rukiasoft.fintonictest.dependencyinjection.subcomponents.SuperHeroListSubcomponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Roll on 31/8/17.
 */
@Singleton
@Component(modules = arrayOf(FintonicAppModule::class))
interface FintonicAppComponent {
    fun getSuperHeroListSubcomponent(module: SuperHeroListModule): SuperHeroListSubcomponent
    fun getSuperHeroDetailSubcomponent(module: SuperHeroDetailModule): SuperHeroDetailSubcomponent

}