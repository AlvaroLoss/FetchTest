package com.example.fetchtest.api

import com.example.fetchtest.models.HiringItem
import kotlinx.coroutines.flow.StateFlow

interface IApiServiceProvider {
    fun getHiringItemsInOrder(): StateFlow<List<HiringItem>>
}