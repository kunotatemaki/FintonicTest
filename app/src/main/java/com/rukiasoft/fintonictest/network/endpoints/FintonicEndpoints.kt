package com.rukiasoft.fintonictest.network.endpoints

import com.rukiasoft.fintonictest.network.model.SuperHeroesResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Roll on 31/8/17.
 */
interface FintonicEndpoints {
    @GET("bins/bvyob")
    fun getSuperHeroes() : Call<SuperHeroesResponse>
}