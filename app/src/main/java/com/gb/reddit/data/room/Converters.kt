package com.gb.reddit.data.room

import androidx.room.TypeConverter
import com.gb.reddit.domain.entity.ItemHot
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listToJson(value: List<ItemHot>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<ItemHot>::class.java).toList()
}