package com.gb.reddit.presentation

import androidx.paging.PagingData
import com.gb.reddit.domain.entity.ItemHot
import kotlinx.coroutines.flow.Flow

interface HotViewModel {
    fun getHotPosts(): Flow<PagingData<ItemHot>>
}