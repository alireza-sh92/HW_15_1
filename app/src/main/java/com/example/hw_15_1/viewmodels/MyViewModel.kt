package com.example.hw_15_1.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.data.City
import com.example.hw_15_1.data.getCityName
import com.example.hw_15_1.recyclerview.MyItemDetailsLookup
import com.example.hw_15_1.recyclerview.MyItemKeyProvider
import com.example.hw_15_1.recyclerview.RecyclerAdapter

class MyViewModel : ViewModel() {
    companion object {
        const val TAG = "MyViewModel"
    }

    private val _cityList = MutableLiveData<List<City>>()
    private val cityList: LiveData<List<City>> = _cityList

    init {
        _cityList.value = getCityName()
    }

    private val _selectedCity = MutableLiveData<List<City>>()
    val selectedCity: LiveData<List<City>> = _selectedCity


    fun setSelectedCity(city: List<City>) {
        _selectedCity.value = city
    }

    fun createTracker(rvCity: RecyclerView, adapterCity: RecyclerAdapter): SelectionTracker<City> {
        return SelectionTracker.Builder(
            "mySelection",
            rvCity,
            MyItemKeyProvider(adapterCity),
            MyItemDetailsLookup(rvCity),
            StorageStrategy.createParcelableStorage(City::class.java)
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()
    }

    fun initTracker(tracker: SelectionTracker<City>, model: MyViewModel) {
        tracker.addObserver(
            object : SelectionTracker.SelectionObserver<City>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()

                    model.setSelectedCity(
                        tracker
                            .selection.map {
                                it
                            }
                    )
                    Log.d(TAG + "ItemSelected", model._selectedCity.value.toString())
                }
            }
        )
    }

    fun get(): List<City>? {
        return if (selectedCity.value.isNullOrEmpty()) {
            cityList.value
        } else {
            cityList.value?.map {
                if (selectedCity.value!!.contains(it)) {

                }
                it
            }
        }
    }
}
