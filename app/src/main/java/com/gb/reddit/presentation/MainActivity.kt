package com.gb.reddit.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gb.reddit.databinding.ActivityMainBinding
import com.gb.reddit.presentation.recycler_view.HotAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: HotViewModelImpl by viewModel()

    private lateinit var binding: ActivityMainBinding

    private val hotAdapter: HotAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        hotCollect()
    }

    private fun initView() {
        binding.hotListRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = hotAdapter
        }
    }

    private fun hotCollect(){
        lifecycleScope.launch {
            viewModel.getHotPosts().collectLatest {
                hotAdapter.submitData(it)
            }
        }
    }

}