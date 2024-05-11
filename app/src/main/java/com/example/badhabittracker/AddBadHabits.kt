package com.example.badhabittracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.badhabittracker.database.BadHabitDB
import com.example.badhabittracker.database.BadHabit
import com.example.badhabittracker.database.BadHabitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddBadHabits : AppCompatActivity() {
    private lateinit var repository: BadHabitRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_bad_habits)

        // Initialize the database
        val db = Room.databaseBuilder(
            applicationContext,
            BadHabitDB::class.java, "BadHabit_db"
        ).build()
        // Initialize the repository
        repository = BadHabitRepository(db)

        var textView1: TextView = findViewById(R.id.badHabit)
        var textView2: TextView = findViewById(R.id.TimePeriod)
        var textView3: TextView = findViewById(R.id.distribution)
        var textView4: TextView = findViewById(R.id.TimeTorecover)
        var addbtn: Button = findViewById(R.id.add_btn)

        addbtn.setOnClickListener {
            val badHabit = BadHabit(
                badHabit = textView1.text.toString(),
                timePeriod = textView2.text.toString(),
                distribution = textView3.text.toString(),
                recoverTime = textView4.text.toString()
            )

            // Insert the BadHabit object into the database
            lifecycleScope.launch(Dispatchers.IO) {
                repository.insert(badHabit)

                // Navigate back to MainActivity
                startActivity(Intent(this@AddBadHabits, MainActivity::class.java))
                finish() // Close the current activity
            }
        }
    }
}