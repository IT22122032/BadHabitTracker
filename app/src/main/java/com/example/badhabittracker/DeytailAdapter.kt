package com.example.badhabittracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.badhabittracker.database.BadHabit


class DeytailAdapter // Set a single sample value
    (private var context: Context) : RecyclerView.Adapter<DeytailViewHolder>() {
    private var habits = emptyList<BadHabit>()

    fun setData(newData: List<BadHabit>) {
        habits = newData
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeytailViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.itemviewholder, parent, false)
        return DeytailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeytailViewHolder, position: Int) {
        val habit = habits[position]
        holder.viewHodertextView1.text = habit.badHabit
        holder.viewHolderTextView2.text = habit.timePeriod
        holder.viewHolderText3.text = habit.distribution
        holder.viewHoldertext4.text = habit.recoverTime


        // Setting click listeners or other operations if needed
        holder.update.setOnClickListener {
            Toast.makeText(context,"update button clicked",Toast.LENGTH_LONG).show()
        }
        holder.delete.setOnClickListener {
            Toast.makeText(context,"Your Bad habit has Gone now",Toast.LENGTH_LONG).show()// Handle delete button click
        }
    }


    override fun getItemCount(): Int {
        return habits.size
    }
}

