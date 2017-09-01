package com.rukiasoft.fintonictest.sherodetails.views

import com.rukiasoft.fintonictest.sherodetails.lifecycleobservers.SuperHeroDetailLifecycleObserver
import com.rukiasoft.fintonictest.sheroeslist.lifecycleobservers.SuperHeroListLifecycleObserver

/**
 * Created by Roll on 31/8/17.
 */
interface SuperHeroDetailView {

    fun addLifecycleObserver(observer: SuperHeroDetailLifecycleObserver)

}