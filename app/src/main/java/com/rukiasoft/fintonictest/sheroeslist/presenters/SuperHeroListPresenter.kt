package com.rukiasoft.fintonictest.sheroeslist.presenters

import android.view.View
import com.rukiasoft.fintonictest.model.SuperHero

/**
 * Created by Roll on 31/8/17.
 */
interface SuperHeroListPresenter {
    fun loadSuperHeroes()

    fun superHeroClicked(superHero: SuperHero)

}