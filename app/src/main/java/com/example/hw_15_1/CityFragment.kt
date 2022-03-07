package com.example.hw_15_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.hw_15_1.databinding.CityFragmentBinding

class CityFragment : Fragment(R.layout.city_fragment) {

    private var fragmentBinding: ViewBinding? = null
    private var layoutmanager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding = CityFragmentBinding.bind(view)
        val rvCity:RecyclerView = view.findViewById<RecyclerView>(R.id.rvCity)
        val listOfCity = getCityName()
        val adapterCity = RecyclerAdapter(listOfCity)
        rvCity.adapter = adapterCity
        rvCity.layoutManager = LinearLayoutManager(activity)

        val changeFragmentBtn:Button = view.findViewById<Button?>(R.id.btChangeFragment)
            .apply {
                setOnClickListener {
                    findNavController().navigate(R.id.selectedFragment)
                }
            }
    }
    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }
}