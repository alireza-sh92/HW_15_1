package com.example.hw_15_1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw_15_1.data.City
import com.example.hw_15_1.data.getCityName

class MyViewModel : ViewModel() {
    private val _cityList = MutableLiveData<List<City>>()
    val cityList: LiveData<List<City>> = _cityList

    private val _selectedCity = MutableLiveData<List<City>>()
    val selectedCity:LiveData<List<City>> = _selectedCity

    init {
            _cityList.value = getCityName()

    }

    fun setSelectedCity(citys: List<City>) {
        _selectedCity.value = citys
    }


}