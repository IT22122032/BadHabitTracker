package com.example.badhabittracker.database

class BadHabitRepository (

        private val db:BadHabitDB
    ) {
        suspend fun insert(badHabit:BadHabit) = db.getBadHabit().insertBadHabit(badHabit)
        suspend fun delete(badHabit:BadHabit) = db.getBadHabit().deleteBadHabit(badHabit)
        fun getAllTodoItems():List<BadHabit> = db.getBadHabit().getAllTodoItems()

        suspend fun update(badHabit: BadHabit) = db.getBadHabit().updateBadHabit(badHabit)
    }
