package com.example.fetchtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.size
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fetchtest.api.ApiService
import com.example.fetchtest.api.ApiServiceProvider
import com.example.fetchtest.databinding.ActivityMainBinding
import com.example.fetchtest.models.HiringItem
import com.example.fetchtest.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HiringItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,
            ViewModelFactory.viewModelFactory {
                MainViewModel(ApiServiceProvider( ApiService())) })
            .get(MainViewModel::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            viewModel.hiringItemFlow.collect { hiringItems ->
                if(hiringItems.isNotEmpty()) {
                    setUpRecyclerView(hiringItems)
                }
            }
        }
    }

    private fun setUpRecyclerView(data: List<HiringItem>) {
        adapter = HiringItemsAdapter(data)
        binding.hiringListRv.layoutManager = LinearLayoutManager(this)
        binding.hiringListRv.adapter = adapter
    }
}