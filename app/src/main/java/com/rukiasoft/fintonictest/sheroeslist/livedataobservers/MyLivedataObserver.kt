package com.rukiasoft.fintonictest.sheroeslist.livedataobservers

import com.rukiasoft.fintonictest.model.SuperHero

/**
 * Created by Roll on 31/8/17.
 */
interface MyLivedataObserver {

    fun handleChangesInObservedSuperHeroes(superheroes: MutableList<SuperHero>)

}