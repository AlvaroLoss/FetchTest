package com.example.fetchtest.viewmodels

import com.example.fetchtest.models.HiringItem
import kotlinx.coroutines.flow.StateFlow

interface IMainViewModel {
    val hiringItemFlow: StateFlow<List<HiringItem>>
}
