package com.example.hw_15_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.databinding.SelectedFragmentBinding
import com.example.hw_15_1.recyclerview.RecyclerAdapter
import com.example.hw_15_1.viewmodels.SharedViewModel

class SelectedCityFragment : Fragment(R.layout.selected_fragment) {
    private var fragmentBinding: SelectedFragmentBinding? = null
    private var layoutmanager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private val model: SharedViewModel by activityViewModels()

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
        val rvSelectedCity: RecyclerView? =fragmentBinding?.rvSelectedCity


//        val adapterSelectedCity = RecyclerAdapter()
//        rvSelectedCity.adapter = adapterSelectedCity
//        rvSelectedCity.layoutManager = LinearLayoutManager(activity)
//
    }
    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }
}