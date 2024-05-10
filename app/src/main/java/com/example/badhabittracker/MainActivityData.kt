package com.example.badhabittracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.badhabittracker.database.BadHabit

class MainActivityData:ViewModel(){
    private val _data = MutableLiveData<List<BadHabit>>()
    val data: LiveData<List<BadHabit>> = _data
    fun setData(data:List<BadHabit>){
        _data.value = data
    }
}