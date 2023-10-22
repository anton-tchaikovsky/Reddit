package com.gb.reddit.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gb.reddit.data.data_source.HotListingPagingDataSource
import com.gb.reddit.data.service.HotService
import com.gb.reddit.domain.entity.ItemHot
import kotlinx.coroutines.flow.Flow

class HotRepositoryImpl(private val hotService: HotService) : HotRepository {
    override fun getHot(): Flow<PagingData<ItemHot>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = true
            ),
        pagingSourceFactory = {HotListingPagingDataSource(hotService)}
        ).flow

    companion object {
        private const val PAGE_SIZE = 25
    }
}