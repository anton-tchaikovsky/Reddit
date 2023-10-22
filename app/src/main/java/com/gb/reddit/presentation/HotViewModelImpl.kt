package com.gb.reddit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gb.reddit.data.repository.HotRepository
import com.gb.reddit.domain.entity.ItemHot
import kotlinx.coroutines.flow.Flow

class HotViewModelImpl(private val repository: HotRepository): ViewModel(), HotViewModel {
    override fun getHotPosts(): Flow<PagingData<ItemHot>> {
        return repository.getHot().cachedIn(viewModelScope)
    }
}