package com.example.badhabittracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class DeytailAdapter // Set a single sample value
    (private var context: Context) : RecyclerView.Adapter<DeytailViewHolder>() {
    private val sampleValue = mutableListOf<String>()
    init {
        // Initialize sample values
        for (i in 1..10) {
            sampleValue.add("Sample Text $i")
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeytailViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.itemviewholder, parent, false)
        context =parent.context
        return DeytailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeytailViewHolder, position: Int) {
        // Set sample text value for all TextViews
        val sampleValue = sampleValue[position]
        holder.viewHodertextView1.text = sampleValue
        holder.viewHolderTextView2.text = sampleValue
        holder.viewHolderText3.text = sampleValue
        holder.viewHoldertext4.text = sampleValue

        // Setting click listeners or other operations if needed
        holder.update.setOnClickListener {
            Toast.makeText(context,"update button clicked",Toast.LENGTH_LONG).show()
        }
        holder.delete.setOnClickListener {
            Toast.makeText(context,"Your Bad habit has Gone now",Toast.LENGTH_LONG).show()// Handle delete button click
        }
    }


    override fun getItemCount(): Int {
        // Return the number of items in your dataset
        return sampleValue.size
    }
}

