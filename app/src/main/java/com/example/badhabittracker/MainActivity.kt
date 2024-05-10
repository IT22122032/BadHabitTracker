package com.example.badhabittracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView=findViewById(R.id.habittesRecycleView)
        // Create an instance of your adapter
        val adapter = DeytailAdapter(this)

        // Set up the RecyclerView with the adapter
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val addbtn = findViewById<Button>(R.id.addButton) // Moved this line here

       addbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}