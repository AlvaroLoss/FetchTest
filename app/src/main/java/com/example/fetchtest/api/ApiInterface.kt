package com.example.fetchtest.api

import com.example.fetchtest.models.HiringItem

interface ApiInterface {
    suspend fun fetchHiringItems(): List<HiringItem>
}