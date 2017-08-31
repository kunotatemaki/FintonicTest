package com.rukiasoft.fintonictest.resources

import android.content.Context
import javax.inject.Singleton
import javax.inject.Inject
import com.rukiasoft.amaristest.utils.logger.LoggerHelper



/**
 * Created by Roll on 31/8/17.
 */
@Singleton
class ResourcesManagerAndroidImpl @Inject constructor(): ResourcesManager {

    @Inject
    lateinit var log: LoggerHelper

    @Inject
    lateinit var context: Context

    override fun getString(resId: Int): String {
        return context.getString(resId)

    }

}