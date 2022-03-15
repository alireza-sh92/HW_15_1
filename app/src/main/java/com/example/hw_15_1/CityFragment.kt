package com.example.hw_15_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.data.City
import com.example.hw_15_1.databinding.CityFragmentBinding
import com.example.hw_15_1.recyclerview.RecyclerAdapter
import com.example.hw_15_1.viewmodels.MyViewModel

class CityFragment : Fragment(R.layout.city_fragment) {
    companion object {
        const val TAG = "City Fragment"
    }

    private lateinit var fragmentBinding: CityFragmentBinding
    private val model: MyViewModel by activityViewModels()
    private lateinit var tracker: SelectionTracker<City>
    private lateinit var rvCity: RecyclerView
    private lateinit var adapterCity: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = CityFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCity = fragmentBinding.rvCity
        adapterCity = RecyclerAdapter(model.get())
        rvCity.layoutManager = LinearLayoutManager(context)
        rvCity.adapter = adapterCity
        adapterCity.notifyDataSetChanged()

        tracker = model.createTracker(rvCity, adapterCity)
        adapterCity.tracker = tracker
        model.initTracker(tracker, model)

        button()
    }

    private fun button() {
        fragmentBinding.btChangeFragment.setOnClickListener {
            if (!tracker.selection.isEmpty) {
                findNavController().navigate(R.id.selectedFragment)
            } else {
                makeText(context, "Select An Item!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}