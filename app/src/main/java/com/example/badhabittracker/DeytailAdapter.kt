package com.example.badhabittracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class DeytailAdapter // Set a single sample value
    (private val context: Context) : RecyclerView.Adapter<DeytailViewHolder>() {
    private val sampleValue = "Sample Text"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeytailViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.itemviewholder, parent, false)
        return DeytailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeytailViewHolder, position: Int) {
        // Set sample text value for all TextViews
        holder.viewHodertextView1.text = sampleValue
        holder.viewHolderTextView2.text = sampleValue
        holder.viewHolderText3.text = sampleValue
        holder.viewHoldertext4.text = sampleValue

        // Setting click listeners or other operations if needed
        holder.update.setOnClickListener {
            // Handle update button click
        }
        holder.delete.setOnClickListener {
            // Handle delete button click
        }
    }

    override fun getItemCount(): Int {
        // Return the number of items in your dataset
        return 1 // Since there's only one sample value
    }
}

