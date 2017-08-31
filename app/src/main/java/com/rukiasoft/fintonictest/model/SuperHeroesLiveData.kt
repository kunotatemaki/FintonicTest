package com.rukiasoft.amaristest.model

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.view.View
import com.rukiasoft.fintonictest.model.SuperHeroe
import com.rukiasoft.fintonictest.sheroeslist.livedataobservers.MyLivedataObserver
import javax.inject.Inject


/**
 * Created by Roll on 24/8/17.
 */
class SuperHeroesLiveData @Inject constructor(): MutableLiveData<MutableList<SuperHeroe>>(), CustomLiveData<MutableList<SuperHeroe>> {

    override fun setLivedataValue(value: MutableList<SuperHeroe>) {
        this.value = value
    }

    override fun getLivedataValue(): MutableList<SuperHeroe>? {
        return this.value
    }

    override fun addObserverToLivedata(view: LifecycleRegistryOwner, observer: MyLivedataObserver) {

        if (view is LifecycleRegistryOwner) {
            this.observe(view as LifecycleOwner,
                    Observer<MutableList<SuperHeroe>> { SuperHeroes -> observer.handleChangesInObservedSuperHeroes(SuperHeroes!!) })
        }
    }
}