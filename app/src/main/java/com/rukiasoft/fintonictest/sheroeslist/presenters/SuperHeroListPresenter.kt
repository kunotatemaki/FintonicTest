package com.rukiasoft.fintonictest.sheroeslist.presenters

import com.rukiasoft.fintonictest.model.SuperHero
import com.rukiasoft.fintonictest.sheroeslist.views.SuperHeroView

/**
 * Created by Roll on 31/8/17.
 */
interface SuperHeroListPresenter {
    fun loadSuperHeroes()

    fun superHeroClicked(superHeroView: SuperHeroView, superHero: SuperHero)

}