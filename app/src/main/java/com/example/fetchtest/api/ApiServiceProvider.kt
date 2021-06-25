package com.example.fetchtest.api

import com.example.fetchtest.models.HiringItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiServiceProvider(
    private val apiService: ApiInterface
) : IApiServiceProvider {
    override fun getHiringItemsInOrder(): StateFlow<List<HiringItem>> {
        val mutableStateFLow = MutableStateFlow(emptyList<HiringItem>())
        GlobalScope.launch {
            val list =
                apiService.fetchHiringItems()
                    .filter { !it.name.isNullOrEmpty() }
                    .sortedBy { it.name }
                    .sortedBy { it.id }
            mutableStateFLow.emit(list)
        }
        return mutableStateFLow
    }
}