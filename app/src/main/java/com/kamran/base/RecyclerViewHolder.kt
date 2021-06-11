package com.kamran.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view){
    open fun onViewAttachedToWindow(){}
    open fun onViewDetachedFromWindow() {}
}