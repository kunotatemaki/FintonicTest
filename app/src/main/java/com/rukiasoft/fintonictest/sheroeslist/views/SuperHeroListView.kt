package com.rukiasoft.fintonictest.sheroeslist.views

import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.fintonictest.model.SuperHero
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserver

/**
 * Created by Roll on 31/8/17.
 */
interface SuperHeroListView {

    fun addLifecycleObserver(observer: SuperHeroListLifecycleObserver)

    fun getLiveSuperHeroes(): CustomLiveData<MutableList<SuperHero>>

    fun setSuperHeroesInView(superHeroes: List<SuperHero>)

    fun showEmptyList(message: String)

    fun hideEmptyList()

    fun showLoader()

    fun hideLoader()
}