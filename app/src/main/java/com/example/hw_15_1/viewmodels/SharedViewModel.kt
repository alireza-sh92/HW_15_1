package com.example.hw_15_1.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw_15_1.data.City

class SharedViewModel: ViewModel() {
    // Mutable LiveData which observed by LiveData
    // and updated to EditTexts when it is changed.
    private val mutableLiveData: MutableLiveData<List<City>> = MutableLiveData()

    // function to set the changed
    // data from the EditTexts
    fun setData(input: List<City>) {
        mutableLiveData.value = input
    }

    // function to get the changed data from the EditTexts
    fun getData(): MutableLiveData<List<City>> = mutableLiveData
}
