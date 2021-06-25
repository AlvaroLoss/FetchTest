package com.example.fetchtest.api

import com.example.fetchtest.models.HiringItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService: ApiInterface {

     private val hiringService by lazy {
        create()
    }

    private fun create(): RetrofitInterface {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .build()

        return retrofit.create(RetrofitInterface::class.java)
    }

    override suspend fun fetchHiringItems(): List<HiringItem> {
        return hiringService.fetchHiringItems()
    }

}