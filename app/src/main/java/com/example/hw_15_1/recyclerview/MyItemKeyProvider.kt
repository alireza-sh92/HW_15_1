package com.example.hw_15_1.recyclerview

import androidx.recyclerview.selection.ItemKeyProvider
import com.example.hw_15_1.City

class MyItemKeyProvider(private val adapter: RecyclerAdapter) : ItemKeyProvider<City>(SCOPE_CACHED) {
    override fun getKey(position: Int): City? {
        return adapter.getItem(position)
    }

    override fun getPosition(key: City): Int {
        return adapter.getPosition(key.)
    }

}