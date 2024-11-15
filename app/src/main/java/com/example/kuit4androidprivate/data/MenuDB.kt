package com.example.kuit4androidprivate.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MenuData::class], version = 1)
abstract class MenuDB: RoomDatabase() {
    abstract fun MenuDao() : MenuDao
}