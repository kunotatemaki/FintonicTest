package com.rukiasoft.fintonictest.sheroeslist.viewmodels

import android.arch.lifecycle.ViewModel
import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.amaristest.model.SuperHeroesLiveData
import com.rukiasoft.fintonictest.model.SuperHero

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroListViewModel: ViewModel() {
    val superheroes: CustomLiveData<MutableList<SuperHero>> = SuperHeroesLiveData()
}