package com.example.kuit4androidprivate.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MenuData::class], version = 1)
abstract class MenuDB: RoomDatabase() {
    abstract fun menuDataDao(): MenuDataDao

    companion object{
        /**
         * @Volatile로 여러 thread에서 안전하게 접근할 수 있도록 함
         * 초기화가 끝나기 전에 다른 thread에서 instance를 읽지 못하도록 보장
         */
        @Volatile
        private var instance: MenuDB? = null

        fun getInstance(context: Context):MenuDB{
            /**
             * instance가 이미 있으면 synchronized 블록을 거치지 않고 return,
             * 없으면 synchronized 블록을 거쳐서 instance를 생성하고 return
             */
            return instance ?: synchronized(this){
                instance ?: Room.databaseBuilder(
                    // 앱의 전체 생명주기 동안 사용하려면 applicationContext로 사용
                    context.applicationContext,
                    MenuDB::class.java,
                    "menu_database"
                ).build().also { instance = it }
            }

        }
    }
}