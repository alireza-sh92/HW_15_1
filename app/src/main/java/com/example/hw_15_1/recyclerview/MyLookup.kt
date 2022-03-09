package com.example.hw_15_1.recyclerview

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_15_1.City

class MyLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<City>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<City>? {
        val view = recyclerView.findChildViewUnder(e.x, e.y)
        if (view != null) {
            return (recyclerView.getChildViewHolder(view) as RecyclerAdapter.ViewHolder)
                .getItem()
        }
        return null
    }
}