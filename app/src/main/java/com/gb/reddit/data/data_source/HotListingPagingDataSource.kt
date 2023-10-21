package com.gb.reddit.data.data_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gb.reddit.data.retrofit.HotApi
import com.gb.reddit.domain.entity.ItemHot

class HotListingPagingDataSource(private val hotApi: HotApi) : PagingSource<String, ItemHot>() {
    override fun getRefreshKey(state: PagingState<String, ItemHot>): String? = STARTING_PAGE_INDEX

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ItemHot> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = hotApi.loadHotListing(page)
            LoadResult.Page(
                data = response.hotListingData.children.map {
                    it.itemHot
                },
                prevKey = null,
                nextKey = if (response.hotListingData.children.isEmpty()) null else response.hotListingData.after
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = ""
    }
}