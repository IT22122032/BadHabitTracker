package com.example.badhabittracker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BadHabitDAO {
    @Insert
    suspend fun insertBadHabit(badHabit:BadHabit)
    @Delete
    suspend fun deleteBadHabit(badHabit: BadHabit)

    @Query("SELECT * FROM BadHabit")
    fun getAllTodoItems():List<BadHabit>
}