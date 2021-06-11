package com.kamran.base

import android.view.View

abstract class BaseViewHolder<TYPE>(
    view: View
) : RecyclerViewHolder(view) {
    abstract fun bindData(data: TYPE, position: Int)
}