package com.kamran.base

import com.kamran.constant.MAX_SPAN

abstract class BaseRecyclerItem {
    abstract val itemLayout: Int
    abstract val numberOfColumns: Int
    var position: Int = -1
    var itemClickListener: RecyclerItemClickListener? = null

    open fun getSpan(): Int {
        if (numberOfColumns <= 0 || numberOfColumns > MAX_SPAN)
            return MAX_SPAN
        return MAX_SPAN / numberOfColumns
    }

    abstract fun onBindItem(holder: RecyclerViewHolder, position: Int)
}