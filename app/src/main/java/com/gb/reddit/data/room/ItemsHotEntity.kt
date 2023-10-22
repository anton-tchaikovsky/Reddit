package com.gb.reddit.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gb.reddit.domain.entity.ItemHot

@Entity
data class ItemsHotEntity (
    @PrimaryKey
    val id: String,
    val page: Int,
    val after: String?,
    val itemsHot: List<ItemHot>
)