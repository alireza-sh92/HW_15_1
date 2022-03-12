package com.example.hw_15_1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw_15_1.data.City
import com.example.hw_15_1.data.getCityName

class MyViewModel: ViewModel() {
    private val city:MutableLiveData<List<City>> by lazy {
        MutableLiveData<List<City>>().also {
            loadCity()
        }
    }
    fun getCity():LiveData<List<City>> {
        return city
    }
    private fun loadCity() {
        getCityName()
    }


}