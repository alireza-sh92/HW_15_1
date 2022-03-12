package com.example.hw_15_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.data.City
import com.example.hw_15_1.data.getCityName
import com.example.hw_15_1.databinding.CityFragmentBinding
import com.example.hw_15_1.recyclerview.MyItemDetailsLookup
import com.example.hw_15_1.recyclerview.MyItemKeyProvider
import com.example.hw_15_1.recyclerview.RecyclerAdapter
import com.example.hw_15_1.viewmodels.SharedViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CityFragment : Fragment(R.layout.city_fragment) {
    private var mySharedViewModel: SharedViewModel? = null
    private lateinit var selectedCity: List<City>
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
        val sendDataButton:FloatingActionButton = fragmentBinding.btChangeFragment
        sendDataButton.setOnClickListener {
            mySharedViewModel?.setData(selectedCity)
        }
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvCity: RecyclerView = fragmentBinding.rvCity

        val adapterCity = RecyclerAdapter(getCityName())
        rvCity.adapter = adapterCity
        rvCity.layoutManager = LinearLayoutManager(activity)

       val bt =  fragmentBinding.btChangeFragment
            .apply {
                setOnClickListener {
                    findNavController().navigate(R.id.selectedFragment)
                }
            }
        tracker = SelectionTracker.Builder<City>(
            "mySelection",
            rvCity,
            MyItemKeyProvider(adapterCity),
            MyItemDetailsLookup(rvCity),
            StorageStrategy.createParcelableStorage(City::class.java)
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        adapterCity.tracker = tracker



    }
}
