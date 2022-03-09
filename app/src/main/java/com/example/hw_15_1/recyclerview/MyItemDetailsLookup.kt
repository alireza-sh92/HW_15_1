package com.example.hw_15_1.recyclerview

import android.util.Log
import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.data.City

class MyItemDetailsLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<City>() {
    companion object{
        const val TAG = "MyItemDetailsLookup"
    }
    override fun getItemDetails(e: MotionEvent): ItemDetails<City>? {
        val view = recyclerView.findChildViewUnder(e.x, e.y)
        Log.d(TAG, "${e.x} + ${e.y}")
        if (view != null) {
            return (recyclerView.getChildViewHolder(view) as RecyclerAdapter.ViewHolder)
                .getItem()
        }
        return null
    }
}