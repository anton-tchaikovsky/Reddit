package com.gb.reddit.data.service

import com.gb.reddit.data.retrofit.HotApi
import com.gb.reddit.data.room.HotDatabase
import com.gb.reddit.data.room.ItemsHotEntity
import com.gb.reddit.domain.entity.HotListing
import com.gb.reddit.domain.entity.ItemHot

class HotServiceImpl(private val api: HotApi, private val dataBase: HotDatabase) : HotService {

    override suspend fun getItemHot(page: Int): List<ItemHot> =
        getItemsHotFromDataBase(page) ?: getItemsHotFromApi(page)

    private suspend fun getItemsHotFromDataBase(page: Int): List<ItemHot>? =
        dataBase.getHotDao().getItemHotEntityByPage(page)?.itemsHot

    private suspend fun getItemsHotFromApi(page: Int): List<ItemHot> {
        if (page == 1){
            val response = api.loadHotListing(STARTING_AFTER)
            insertToDataBase(response,STARTING_AFTER, page)
            return response.hotListingData.children.map {
                it.itemHot
            }
        } else {
            val prevItemsHotEntity = dataBase.getHotDao().getItemHotEntityByPage(page-1)
            return if (prevItemsHotEntity==null)
                listOf()
            else {
                if(prevItemsHotEntity.after==null)
                    listOf()
                else{
                    val response = api.loadHotListing(prevItemsHotEntity.after)
                    insertToDataBase(response,prevItemsHotEntity.after, page)
                    response.hotListingData.children.map {
                        it.itemHot
                    }
                }
            }
        }

    }

    private suspend fun insertToDataBase(response: HotListing, id: String, page: Int){
        dataBase.getHotDao().insert( ItemsHotEntity(
            id,
            page,
            response.hotListingData.after,
            response.hotListingData.children.map {
                it.itemHot
            }
        ) )
    }

    companion object {
        private const val STARTING_AFTER = ""
    }
}