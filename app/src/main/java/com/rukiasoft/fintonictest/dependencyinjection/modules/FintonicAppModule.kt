package com.rukiasoft.fintonictest.dependencyinjection.modules

import android.content.Context
import com.rukiasoft.amaristest.utils.logger.AndroidLogHelperImpl
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.FintonicApp
import com.rukiasoft.fintonictest.network.logic.NetworkManager
import com.rukiasoft.fintonictest.network.logic.NetworkManagerAndroidImpl
import com.rukiasoft.fintonictest.resources.ResourcesManager
import com.rukiasoft.fintonictest.resources.ResourcesManagerAndroidImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Roll on 31/8/17.
 */
@Module
@Singleton
class FintonicAppModule(private val application: FintonicApp) {

    @Provides
    fun providesFintonicApp() : FintonicApp{
        return application
    }

    @Provides
    fun providesContext(): Context{
        return application.applicationContext
    }

    @Provides
    fun providesNetworkManager(network: NetworkManagerAndroidImpl): NetworkManager {
        return network
    }

    @Provides
    fun providesLogHelper(logger: AndroidLogHelperImpl): LoggerHelper {
        return logger
    }

    @Provides
    fun providesResourcesManager(resources: ResourcesManagerAndroidImpl): ResourcesManager {
        return resources
    }

}