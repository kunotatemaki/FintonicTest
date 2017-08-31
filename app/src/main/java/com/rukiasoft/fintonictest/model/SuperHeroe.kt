package com.rukiasoft.fintonictest.model

import com.rukiasoft.fintonictest.network.model.SuperHeroeElementRespose

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroe (response: SuperHeroeElementRespose) {
    val name : String? = response.name

}