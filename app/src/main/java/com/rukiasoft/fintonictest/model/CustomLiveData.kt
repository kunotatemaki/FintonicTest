package com.rukiasoft.amaristest.model

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistryOwner
import android.view.View
import com.rukiasoft.fintonictest.sheroeslist.livedataobservers.MyLivedataObserver


/**
 * Created by Roll on 24/8/17.
 */
interface CustomLiveData<T> {

    fun setLivedataValue(value: T)

    fun getLivedataValue(): T?

    fun addObserverToLivedata(lifecycleRegistryOwner: LifecycleRegistryOwner, observer: MyLivedataObserver)

}