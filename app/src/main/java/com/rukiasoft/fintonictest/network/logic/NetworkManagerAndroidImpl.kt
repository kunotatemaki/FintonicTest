package com.rukiasoft.fintonictest.network.logic

import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import com.rukiasoft.fintonictest.model.SuperHeroe
import com.rukiasoft.fintonictest.network.endpoints.FintonicEndpoints
import com.rukiasoft.fintonictest.network.model.SuperHeroesResponse
import com.rukiasoft.fintonictest.utils.FintonicConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by Roll on 31/8/17.
 */
class NetworkManagerAndroidImpl @Inject constructor(): NetworkManager {

    val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(FintonicConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Inject
    lateinit var log : LoggerHelper

    override fun getSuperHeroes(superHeroes: CustomLiveData<MutableList<SuperHeroe>>) {

        val fintonicEndpoints = retrofit.create(FintonicEndpoints::class.java)

        val myCall : Call<SuperHeroesResponse> = fintonicEndpoints.getSuperHeroes()
        myCall.enqueue(object : Callback<SuperHeroesResponse> {
            override fun onResponse(call: Call<SuperHeroesResponse>?, response: Response<SuperHeroesResponse>?) {
                if (response?.isSuccessful as Boolean) {
                    val list : MutableList<SuperHeroe> = arrayListOf()
                    //map photos to observable value
                    response.body()
                            ?.superheroes
                            ?.mapTo(list) {
                        SuperHeroe(it)
                    }
                    superHeroes.setLivedataValue(list)

                } else {

                    log.d(this, "respuesta vacía")
                    TODO("leer de la base de datos")
                }
            }

            override fun onFailure(call: Call<SuperHeroesResponse>?, t: Throwable?) {
                log.d(this, t?.message.toString())
                TODO("leer de la base de datos")

            }
        })
    }
}