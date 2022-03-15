package com.example.hw_15_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.data.City
import com.example.hw_15_1.databinding.SelectedFragmentBinding
import com.example.hw_15_1.recyclerview.MyItemDetailsLookup
import com.example.hw_15_1.recyclerview.MyItemKeyProvider
import com.example.hw_15_1.recyclerview.RecyclerAdapter
import com.example.hw_15_1.viewmodels.MyViewModel

class SelectedCityFragment : Fragment(R.layout.selected_fragment) {
    private var fragmentBinding: SelectedFragmentBinding? = null
    private var layoutmanager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private val model: MyViewModel by activityViewModels()
    private var tracker: SelectionTracker<City>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = SelectedFragmentBinding.inflate(inflater, container, false)
        return fragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapterInitialize()
    }

    private fun recyclerAdapterInitialize() {
        val rvCity: RecyclerView? = fragmentBinding?.rvCity
        val mySelectedCityList: List<City>? = model.selectedCity.value!!
        val adapterCity = RecyclerAdapter(mySelectedCityList)

        rvCity?.layoutManager = LinearLayoutManager(context)
        rvCity?.adapter = adapterCity
        adapterCity.notifyDataSetChanged()

        tracker = rvCity?.let {
            SelectionTracker.Builder<City>(
                "mySelection",
                it,
                MyItemKeyProvider(adapterCity),
                MyItemDetailsLookup(rvCity),
                StorageStrategy.createParcelableStorage(City::class.java)
            ).withSelectionPredicate(
                SelectionPredicates.createSelectAnything<City?>()
            ).build()
        }



        adapterCity.tracker = tracker


    }
}