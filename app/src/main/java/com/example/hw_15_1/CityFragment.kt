package com.example.hw_15_1

import android.os.Bundle
import android.util.Log
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
import com.example.hw_15_1.databinding.CityFragmentBinding
import com.example.hw_15_1.recyclerview.MyItemDetailsLookup
import com.example.hw_15_1.recyclerview.MyItemKeyProvider
import com.example.hw_15_1.recyclerview.RecyclerAdapter
import com.example.hw_15_1.viewmodels.MyViewModel

class CityFragment : Fragment(R.layout.city_fragment) {
    companion object{
        const val TAG = "City Fragment"
    }
    private lateinit var selectedCity: List<City>
    private lateinit var fragmentBinding: CityFragmentBinding
    private val model: MyViewModel by activityViewModels()
    private var tracker: SelectionTracker<City>? = null


    private lateinit var layoutmanager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
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
        recyclerAdapterInitialize()



        val bt = fragmentBinding.btChangeFragment
        bt.setOnClickListener {
            if (tracker?.selection?.isEmpty != true){
                findNavController().navigate(R.id.selectedFragment)
            }
        }



    }

    private fun recyclerAdapterInitialize() {
        val rvCity: RecyclerView = fragmentBinding.rvCity
        val myCityList: List<City> = model.cityList.value!!
        val adapterCity = RecyclerAdapter(myCityList)

        rvCity.layoutManager = LinearLayoutManager(context)
        rvCity.adapter = adapterCity
        adapterCity.notifyDataSetChanged()

        tracker = SelectionTracker.Builder<City>(
            "mySelection",
            rvCity,
            MyItemKeyProvider(adapterCity),
            MyItemDetailsLookup(rvCity),
            StorageStrategy.createParcelableStorage(City::class.java)
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything<City?>()
        ).build()

        tracker?.addObserver(
            object : SelectionTracker.SelectionObserver<City>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()
                    val litst = tracker!!.selection.map {
                        it
                    }
                    Log.d(TAG,litst.toString())
                    model.setSelectedCity(litst)

                }

            }
        )

        adapterCity.tracker = tracker


    }
}
