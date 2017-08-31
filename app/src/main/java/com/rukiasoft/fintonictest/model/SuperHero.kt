package com.rukiasoft.fintonictest.model

import com.rukiasoft.fintonictest.network.model.SuperHeroElementRespose

/**
 * Created by Roll on 31/8/17.
 */
class SuperHero(response: SuperHeroElementRespose) {
    val name : String? = response.name
    val photo: String? = response.photo
    val realName: String? = response.realName
    val height: String? = response.height
    val power: String? = response.power
    val abilities: String? = response.abilities
    val groups: String? = response.groups
}