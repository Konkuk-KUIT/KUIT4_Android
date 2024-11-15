package com.example.kuit4androidprivate.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

//스키마가 바뀌거나 뭐하거나 하면 버전 업그레이드
@Database(entities = [MenuCategoryData::class], version = 1)
abstract class MenuCategoryDB : RoomDatabase() {
    abstract fun MenuCategoryDao(): MenuCategoryDao

    companion object {
        private var instance: MenuCategoryDB? = null
        @Synchronized
        fun getInstance(context: Context): MenuCategoryDB {
            if (instance == null) {
                instance=Room.databaseBuilder(
                    context,
                    MenuCategoryDB::class.java,
                    "menu_category_database"
                    //이름 똑같으면 오류남
                ).build()
            }
            return instance!!
        }
    }
}