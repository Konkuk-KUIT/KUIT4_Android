package com.example.kuit4androidprivate.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MenuCategoryData::class], version = 1, exportSchema = false)
abstract class MenuCategoryDB : RoomDatabase() {
    abstract fun menuCategoryDao(): MenuCategoryDao

    companion object {
        @Volatile
        private var INSTANCE: MenuCategoryDB? = null

        fun getDatabase(context: Context): MenuCategoryDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MenuCategoryDB::class.java,
                    "menu_category_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}