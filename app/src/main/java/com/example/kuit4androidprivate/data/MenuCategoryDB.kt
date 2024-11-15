package com.example.kuit4androidprivate.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MenuCategoryData::class], version = 1)
abstract class MenuCategoryDB : RoomDatabase(){
    abstract fun MenuCategoryDao() : MenuCategoryDao
}