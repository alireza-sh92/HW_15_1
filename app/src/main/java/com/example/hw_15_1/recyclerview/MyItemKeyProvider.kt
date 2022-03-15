package com.example.hw_15_1.recyclerview

import android.util.Log
import androidx.recyclerview.selection.ItemKeyProvider
import com.example.hw_15_1.data.City

class MyItemKeyProvider(private val adapter: RecyclerAdapter) :
    ItemKeyProvider<City>(SCOPE_CACHED) {
    companion object {
        const val TAG = "MyItemKeyProvide "
    }

    override fun getKey(position: Int): City? {
        Log.d(TAG + "getKey", adapter.getItem(position).toString())
        return adapter.getItem(position)
    }

    override fun getPosition(key: City): Int {
        Log.d(TAG + "getPos", adapter.getPosition(key.name).toString())
        return adapter.getPosition(key.name)!!
    }
}