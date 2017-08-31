package com.rukiasoft.amaristest.model

import android.view.View
import com.rukiasoft.fintonictest.sheroeslist.livedataobservers.MyLivedataObserver


/**
 * Created by Roll on 24/8/17.
 */
interface CustomLiveData<T> {

    fun setLivedataValue(value: T)

    fun getLivedataValue(): T?

    fun addObserverToLivedata(view: View, observer: MyLivedataObserver)

}