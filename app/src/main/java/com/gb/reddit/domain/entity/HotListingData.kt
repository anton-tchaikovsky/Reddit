package com.gb.reddit.domain.entity

data class HotListingData(
    val after: String?,
    val before: String?,
    val children: List<HotListingItem>,
    val dist: Int
)