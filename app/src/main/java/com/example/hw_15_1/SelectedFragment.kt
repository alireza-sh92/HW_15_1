package com.example.hw_15_1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class SelectedFragment:Fragment(R.layout.selected_fragment) {
    private  var fragmentBinding: ViewBinding? = null
    private var layoutmanager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvSelectedCity:RecyclerView = view.findViewById(R.id.rvSelectedCity)

//        Must Be Delete After Impl
        val listOfCity = getCityName()
//        Must Be Delete After Impl

        val adapterSelectedCity = RecyclerAdapter(listOfCity)
        rvSelectedCity.adapter = adapterSelectedCity
        rvSelectedCity.layoutManager = LinearLayoutManager(activity)
    }
}