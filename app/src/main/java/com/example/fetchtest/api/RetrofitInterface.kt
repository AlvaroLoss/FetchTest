package com.example.fetchtest.api

import com.example.fetchtest.models.HiringItem
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("hiring.json")
    suspend fun fetchHiringItems(): List<HiringItem>
}