package com.example.hw_15_1.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.R
import com.example.hw_15_1.data.City

class RecyclerAdapter(private val cityList: List<City>?) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var tracker: SelectionTracker<City>? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var cityTextView = itemView.findViewById<TextView>(R.id.tvCityName)

        fun bind(value: String, isActivated: Boolean = false) {
            cityTextView.text = value
            itemView.isActivated = isActivated
        }

        fun getItem(): ItemDetailsLookup.ItemDetails<City> =
            object : ItemDetailsLookup.ItemDetails<City>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): City? = cityList?.get(position)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val cityView = inflater.inflate(R.layout.custom_view, parent, false)
        return ViewHolder(cityView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city: City = cityList!![position]
        tracker?.let {
            holder.bind(city.name, it.isSelected(city))
        }
    }

    override fun getItemCount(): Int {
        return cityList!!.size
    }

    fun getItem(position: Int) = cityList?.get(position)
    fun getPosition(name: String) = cityList?.indexOfFirst { it.name == name }

}