package com.example.badhabittracker

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.badhabittracker.database.BadHabitDB
import com.example.badhabittracker.database.BadHabitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DeytailAdapter
    private lateinit var repository: BadHabitRepository
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            BadHabitDB::class.java, "BadHabit_db"
        ).build()

        // Initialize the repository
        repository = BadHabitRepository(db)

        val recyclerView:RecyclerView=findViewById(R.id.habittesRecycleView)
        // Create an instance of your adapter
        adapter = DeytailAdapter(this, lifecycleScope, repository)

        // Set up the RecyclerView with the adapter
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = adapter
        // Fetch data from the database and populate the RecyclerView
        fetchDataFromDatabase()
        // Add button click listener
        val addbtn = findViewById<Button>(R.id.addButton) // Moved this line here

       addbtn.setOnClickListener {
            val intent = Intent(this, AddBadHabits::class.java)
            startActivity(intent)
        }
        // Initialize and set up the search EditText
        searchEditText = findViewById(R.id.searchEditText)
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // When text changes, filter the data based on the search query
                filterData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }


    private fun fetchDataFromDatabase() {
        lifecycleScope.launch(Dispatchers.IO) {
            val habits = repository.getAllTodoItems()
            withContext(Dispatchers.Main) {
                adapter.setData(habits)
            }
        }
    }
    private fun filterData(query: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            val filteredHabits = repository.searchHabits(query)
            withContext(Dispatchers.Main) {
                adapter.setData(filteredHabits)
            }
        }
    }
}