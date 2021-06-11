package com.kamran.base

import android.view.View

interface RecyclerItemClickListener {
    fun onItemClick(view: View, position:Int, itemData: Any)
}