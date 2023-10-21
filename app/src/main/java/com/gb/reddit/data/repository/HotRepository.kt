package com.gb.reddit.data.repository

import androidx.paging.PagingData
import com.gb.reddit.domain.entity.ItemHot
import kotlinx.coroutines.flow.Flow

interface HotRepository {
    fun getHot(): Flow<PagingData<ItemHot>>
}