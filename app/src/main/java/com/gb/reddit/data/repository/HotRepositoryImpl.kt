package com.gb.reddit.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gb.reddit.data.data_source.HotListingPagingDataSource
import com.gb.reddit.data.retrofit.HotApi
import com.gb.reddit.domain.entity.ItemHot
import kotlinx.coroutines.flow.Flow

class HotRepositoryImpl(private val hotApi: HotApi) : HotRepository {
    override fun getHot(): Flow<PagingData<ItemHot>> =
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = true,
                initialLoadSize = PAGE_SIZE
            ),
        pagingSourceFactory = {HotListingPagingDataSource(hotApi)}
        ).flow

    companion object {
        private const val PAGE_SIZE = 25
    }
}