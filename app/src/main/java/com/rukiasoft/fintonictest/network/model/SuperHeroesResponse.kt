package com.rukiasoft.fintonictest.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Roll on 31/8/17.
 */
class SuperHeroesResponse{

    @SerializedName("superheroes")
    @Expose
    var superheroes: List<SuperHeroElementRespose>? = null

}