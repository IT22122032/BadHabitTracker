package com.example.badhabittracker

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DeytailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var BadHabitLable: TextView
    var viewHodertextView1: TextView
    var TimePeriodLable:TextView
    var viewHolderTextView2: TextView
    var DistributionLable:TextView
    var viewHolderText3: TextView
    var TimeTocureLable:TextView
    var viewHoldertext4: TextView
    var update: Button
    var delete: Button

    init {
        BadHabitLable=itemView.findViewById(R.id.BadHabitLable)
        viewHodertextView1 = itemView.findViewById(R.id.viewHodertextView1)
        TimePeriodLable = itemView.findViewById(R.id.TimePeriodLable)
        viewHolderTextView2 = itemView.findViewById(R.id.ViewHoldertextView2)
        DistributionLable = itemView.findViewById(R.id.DistributionLable)
        viewHolderText3 = itemView.findViewById(R.id.viewHolderText3)
        TimeTocureLable = itemView.findViewById(R.id.TimeTocureLable)
        viewHoldertext4 = itemView.findViewById(R.id.viewHoldertext4)
        update = itemView.findViewById(R.id.update)
        delete = itemView.findViewById(R.id.delete)
    }
}

