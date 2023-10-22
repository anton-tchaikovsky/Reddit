package com.gb.reddit.data.service

import com.gb.reddit.domain.entity.ItemHot

interface HotService {
    suspend fun getItemHot(page: Int): List<ItemHot>
}