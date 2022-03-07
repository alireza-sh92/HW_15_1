package com.example.hw_15_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel: ViewModel() {
    private val selected = MutableLiveData<Int>()

    fun select(index:Int){
        selected.value = index
    }
}