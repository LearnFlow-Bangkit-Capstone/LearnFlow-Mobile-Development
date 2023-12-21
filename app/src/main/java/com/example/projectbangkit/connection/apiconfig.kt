package com.example.projectbangkit.connection

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiconfig {
    private const val BASE_URL = "https://learnflow1-hus4nlwi3q-as.a.run.app/"

    val apiService: apiservice by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(apiservice::class.java)
    }
}