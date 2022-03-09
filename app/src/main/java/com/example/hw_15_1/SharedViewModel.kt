package com.example.hw_15_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    val selected = MutableLiveData<Int>()

    fun select(index:Int){
        selected.value = index
    }
}