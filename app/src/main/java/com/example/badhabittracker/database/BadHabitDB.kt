package com.example.badhabittracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BadHabit::class], version = 1)
abstract class BadHabitDB:RoomDatabase() {
    abstract fun getBadHabit():BadHabitDAO
    companion object{
        @Volatile
        private var INSTANCE: RoomDatabase? = null
        fun getInstance(context: Context):RoomDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabase::class.java,
                    "BadHabit_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}