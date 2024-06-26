package com.example.badhabittracker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BadHabitDAO {
    @Insert
    suspend fun insertBadHabit(badHabit:BadHabit)
    @Delete
    suspend fun deleteBadHabit(badHabit: BadHabit)

    @Query("SELECT * FROM BadHabit")
    fun getAllTodoItems():List<BadHabit>

    @Query("DELETE FROM BadHabit")
    suspend fun deleteAll()

    @Update
    suspend fun updateBadHabit(badHabit: BadHabit)

    @Query("SELECT * FROM BadHabit WHERE badHabit LIKE '%' || :query || '%'")
    suspend fun searchHabits(query: String): List<BadHabit>
}