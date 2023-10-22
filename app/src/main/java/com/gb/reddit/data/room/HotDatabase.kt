package com.gb.reddit.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ItemsHotEntity::class], exportSchema = false, version = 1)
@TypeConverters(Converters::class)
abstract class HotDatabase: RoomDatabase() {
    abstract fun getHotDao():HotDao
}