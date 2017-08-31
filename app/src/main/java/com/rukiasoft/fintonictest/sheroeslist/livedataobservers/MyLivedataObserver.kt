package com.rukiasoft.fintonictest.sheroeslist.livedataobservers

import com.rukiasoft.fintonictest.model.SuperHeroe

/**
 * Created by Roll on 31/8/17.
 */
interface MyLivedataObserver {

    fun handleChangesInObservedSuperHeroes(accounts: MutableList<SuperHeroe>)

}