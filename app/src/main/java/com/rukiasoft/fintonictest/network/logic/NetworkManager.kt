package com.rukiasoft.fintonictest.network.logic

import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.fintonictest.model.SuperHeroe

/**
 * Created by Roll on 31/8/17.
 */
interface NetworkManager {

    fun getSuperHeroes(superHeroes: CustomLiveData<MutableList<SuperHeroe>>)

}