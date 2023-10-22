package com.gb.reddit.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HotDao {
    @Insert
    suspend fun insert(itemsHotEntity: ItemsHotEntity)

    @Query("SELECT * FROM ItemsHotEntity WHERE page LIKE :page LIMIT 1")
    suspend fun getItemHotEntityByPage(page: Int): ItemsHotEntity?
}