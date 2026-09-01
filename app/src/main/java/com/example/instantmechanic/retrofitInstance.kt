package com.example.instantmechanic

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue

object RetrofitInstance {

    private const val BASE_URL =
        "http://10.0.2.2:8080/"

    val api: MechanicApi by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MechanicApi::class.java)
    }
}