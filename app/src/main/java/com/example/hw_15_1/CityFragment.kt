package com.example.hw_15_1

import android.os.Bundle
import android.view.ActionMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.databinding.CityFragmentBinding
import com.example.hw_15_1.recyclerview.MyItemKeyProvider
import com.example.hw_15_1.recyclerview.MyLookup
import com.example.hw_15_1.recyclerview.RecyclerAdapter

class CityFragment : Fragment(R.layout.city_fragment) {

    private lateinit var fragmentBinding: CityFragmentBinding
    private lateinit var layoutmanager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
    private val model: SharedViewModel by activityViewModels()
    private lateinit var tracker: SelectionTracker<City>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = CityFragmentBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvCity: RecyclerView = fragmentBinding.rvCity
        val listOfCity = getCityName()
        val adapterCity = RecyclerAdapter(listOfCity)
        rvCity.adapter = adapterCity
        rvCity.layoutManager = LinearLayoutManager(activity)

        fragmentBinding.btChangeFragment
            .apply {
                setOnClickListener {
                    findNavController().navigate(R.id.selectedFragment)
                }
            }
        tracker = SelectionTracker.Builder(
            "mySelection",
            rvCity,
            MyItemKeyProvider(adapterCity),
            MyLookup(rvCity),
            
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        adapterCity.tracker = tracker



    }
}