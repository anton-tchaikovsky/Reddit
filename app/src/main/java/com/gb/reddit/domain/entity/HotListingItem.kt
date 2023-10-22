package com.gb.reddit.domain.entity

import com.google.gson.annotations.SerializedName

data class HotListingItem(
    @SerializedName("data")
    val itemHot: ItemHot,
    val kind: String
)