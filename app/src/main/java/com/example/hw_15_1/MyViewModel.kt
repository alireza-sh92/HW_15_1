package com.example.hw_15_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val city:MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

}