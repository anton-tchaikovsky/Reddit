package com.gb.reddit.domain.entity

import com.google.gson.annotations.SerializedName

data class ItemHot(
    val title: String,
    val ups: Int,
    @SerializedName("num_comments")
    val commentsNumber: Int,
)