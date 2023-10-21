package com.gb.reddit.domain.entity

import com.google.gson.annotations.SerializedName

data class HotListing(
    @SerializedName("data")
    val hotListingData: HotListingData,
    val kind: String
)