package com.rukiasoft.fintonictest.sheroeslist.views

import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.fintonictest.model.SuperHeroe
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserver

/**
 * Created by Roll on 31/8/17.
 */
interface SuperHeroListView {

    fun addLifecycleObserver(observer: SuperHeroListLifecycleObserver)

    fun getLiveSuperHeroes(): CustomLiveData<MutableList<SuperHeroe>>
}