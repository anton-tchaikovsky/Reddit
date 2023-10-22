package com.gb.reddit.data.retrofit

import com.gb.reddit.domain.entity.HotListing
import retrofit2.http.GET
import retrofit2.http.Query

interface HotApi {
    @GET(END_POINT)
    suspend fun loadHotListing(@Query(AFTER_QUERY) after: String): HotListing

    companion object {
        private const val END_POINT = "r/aww/hot.json"
        private const val AFTER_QUERY = "after"
    }

}
