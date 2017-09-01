package com.rukiasoft.fintonictest

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.rukiasoft.amaristest.utils.logger.AndroidLoggerHelperImpl
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.resources.ResourcesManagerAndroidImpl
import com.rukiasoft.fintonictest.test.R

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Roll on 1/9/17.
 */
@RunWith(AndroidJUnit4::class)
class ResourcesTest {

    lateinit var context: Context
    val log: LoggerHelper = AndroidLoggerHelperImpl()
    lateinit var resources: ResourcesManagerAndroidImpl

    @Before
    fun setUp(){
        context = InstrumentationRegistry.getContext()
        resources = ResourcesManagerAndroidImpl(log, context)
    }

    @Test
    fun checkIfLoadStringFromStringsFile(){
        val string = resources.getString(R.string.test_string)
        Assert.assertTrue(string.equals("This string is used to test resources class"))
    }
}


