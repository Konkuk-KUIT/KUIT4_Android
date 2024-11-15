package com.example.kuit4androidprivate.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MenuData::class], version = 1, exportSchema = false)
abstract class MenuDB : RoomDatabase() {
    abstract fun menuDataDao(): MenuDataDao

    companion object {
        @Volatile
        private var INSTANCE: MenuDB? = null

        fun getDatabase(context: Context): MenuDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MenuDB::class.java,
                    "menu_data_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
