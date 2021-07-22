package com.example.fetchtest.viewmodels

import androidx.lifecycle.ViewModel
import com.example.fetchtest.api.ApiServiceProvider
import com.example.fetchtest.models.HiringItem
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

class MainViewModel(
    private val apiServiceProvider: ApiServiceProvider
): ViewModel(), IMainViewModel {
    override val hiringItemFlow: StateFlow<List<HiringItem>> by lazy {
        apiServiceProvider.getHiringItemsInOrder()
    }
}