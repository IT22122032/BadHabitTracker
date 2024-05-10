package com.example.badhabittracker

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DeytailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var viewHodertextView1: TextView
    var viewHolderTextView2: TextView
    var viewHolderText3: TextView
    var viewHoldertext4: TextView
    var update: Button
    var delete: Button

    init {
        viewHodertextView1 = itemView.findViewById(R.id.viewHodertextView1)
        viewHolderTextView2 = itemView.findViewById(R.id.ViewHoldertextView2)
        viewHolderText3 = itemView.findViewById(R.id.viewHolderText3)
        viewHoldertext4 = itemView.findViewById(R.id.viewHoldertext4)
        update = itemView.findViewById(R.id.update)
        delete = itemView.findViewById(R.id.delete)
    }
}

