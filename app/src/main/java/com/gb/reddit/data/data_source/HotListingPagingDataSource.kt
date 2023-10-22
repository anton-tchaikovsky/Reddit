package com.gb.reddit.data.data_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gb.reddit.data.service.HotService
import com.gb.reddit.domain.entity.ItemHot

class HotListingPagingDataSource(private val hotService: HotService) : PagingSource<Int, ItemHot>() {
    override fun getRefreshKey(state: PagingState<Int,ItemHot>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemHot> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val itemsHotEntity = hotService.getItemHot(page)
            LoadResult.Page(
                data = itemsHotEntity,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (itemsHotEntity.isEmpty()) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}