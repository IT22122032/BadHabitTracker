package com.example.badhabittracker

import android.app.Activity
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
import com.example.badhabittracker.database.BadHabit
import com.example.badhabittracker.database.BadHabitDB
import com.example.badhabittracker.database.BadHabitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UpdateHabits : AppCompatActivity() {
    lateinit var badHabitRepository: BadHabitRepository
    lateinit var adapter: DeytailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_habits)

        //initialize views
        var distributiontext: TextView = findViewById(R.id.UpadateDistribution)
        var timetogetridText: TextView = findViewById(R.id.updatetimeTogetRid)
        var updateBtn: Button = findViewById(R.id.updateDta)

        // Retrieve values from intent extras
        val id = intent.getIntExtra("id", 0) // default value if not found
        val badHabit = intent.getStringExtra("badHabit") ?: ""
        val timePeriod = intent.getStringExtra("timePeriod") ?: ""
        val distribution = intent.getStringExtra("distribution") ?: ""
        val recoverTime = intent.getStringExtra("recoverTime") ?: ""

        // Set values to UI elements if needed
        distributiontext.text = distribution
        timetogetridText.text = recoverTime

        // Initialize repository
        val db = Room.databaseBuilder(
            applicationContext,
            BadHabitDB::class.java, "BadHabit_db"
        ).build()
        badHabitRepository = BadHabitRepository(db)

        updateBtn.setOnClickListener {
            // Get updated values from UI
            val updatedDistribution = distributiontext.text.toString()
            val updatedRecoverTime = timetogetridText.text.toString()

            // Create BadHabit object with updated values
            val updatedBadHabit = BadHabit(
                id = id,
                badHabit = badHabit,
                timePeriod = timePeriod,
                distribution = updatedDistribution,
                recoverTime = updatedRecoverTime
            )

            // Update BadHabit in the database
            updateBadHabit(updatedBadHabit)
        }
    }

    private fun updateBadHabit(badHabit: BadHabit) {
        val activityContext = this@UpdateHabits // Capture the activity context
        // Call the update method in the repository
        CoroutineScope(Dispatchers.IO).launch {
            badHabitRepository.update(badHabit)
            // Finish the activity and pass a flag indicating that an update has occurred
            val intent = Intent(activityContext, StartPage::class.java).apply {
                putExtra("updateOccurred", true)
            }
            //setResult(Activity.RESULT_OK, intent)
            activityContext.startActivity(intent)
            // Finish the current activity
            activityContext.finish()
            finish()

        } // Close the activity after updating
    }
}