package com.rukiasoft.fintonictest

import android.app.Application
import com.rukiasoft.fintonictest.dependencyinjection.components.DaggerFintonicAppComponent
import com.rukiasoft.fintonictest.dependencyinjection.components.FintonicAppComponent
import com.rukiasoft.fintonictest.dependencyinjection.modules.FintonicAppModule

/**
 * Created by Roll on 31/8/17.
 */
class FintonicApp: Application() {

    lateinit var mComponent: FintonicAppComponent
    override fun onCreate() {
        super.onCreate()
        mComponent = DaggerFintonicAppComponent.builder()
                .fintonicAppModule(FintonicAppModule(this))
                .build()
    }
}