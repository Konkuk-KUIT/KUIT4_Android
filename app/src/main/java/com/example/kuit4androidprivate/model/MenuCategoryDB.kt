package com.example.kuit4androidprivate.model

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MenuCategoryData::class], version = 1)
abstract class MenuCategoryDB: RoomDatabase() {
    abstract fun menuCategoryDao(): MenuCategoryDao

    companion object{
        private var instance: MenuCategoryDB? = null

        //annotation 붙여서 race condition 방지
        @Synchronized
        fun getInstance(context: Context): MenuCategoryDB{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context,
                    MenuCategoryDB::class.java,
                    "menu_category_database"
                ).build()
            }
            return instance!!
        }
    }
}