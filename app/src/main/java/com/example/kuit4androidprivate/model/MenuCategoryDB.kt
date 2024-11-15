package com.example.kuit4androidprivate.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MenuCategoryData::class], version = 1)
abstract class MenuCategoryDB : RoomDatabase() {
    abstract fun menuCategoryDao(): MenuCategoryDao  //Dao랑 연결

    companion object {
        @Volatile
        private var instance: MenuCategoryDB? = null

        @Synchronized
        fun getInstance(context: Context): MenuCategoryDB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    MenuCategoryDB::class.java,
                    "menu_category_database"
                ).allowMainThreadQueries().build()

            }
            return instance!!
        }
    }
}