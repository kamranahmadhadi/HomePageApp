package com.kamran.base

import android.view.ViewGroup

abstract class BaseViewHolderFactory {

    abstract fun getViewHolder(vhType: Int, parent: ViewGroup): RecyclerViewHolder
}