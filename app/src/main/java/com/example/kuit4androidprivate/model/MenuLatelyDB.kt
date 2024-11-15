package com.example.kuit4androidprivate.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MenuLatelyData::class], version = 1)
abstract class MenuLatelyDB : RoomDatabase() {
    abstract fun menuLatelyDao(): MenuLatelyDao  //Dao랑 연결

    companion object {
        @Volatile
        private var instance: MenuLatelyDB? = null

        @Synchronized
        fun getInstance(context: Context): MenuLatelyDB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    MenuLatelyDB::class.java,
                    "menu_lately_database"
                ).allowMainThreadQueries().build()

            }
            return instance!!
        }
    }
}