package com.example.badhabittracker.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BadHabit(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    val badHabit: String,
    val timePeriod: String,
    val distribution: String,
    val recoverTime: String

)

