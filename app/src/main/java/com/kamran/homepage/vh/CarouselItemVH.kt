package com.kamran.homepage.vh

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.kamran.base.BaseViewHolder
import com.kamran.homepage.BR
import com.kamran.homepage.R
import com.kamran.homepage.model.item.CarouselRecyclerItem

class CarouselItemVH(private val itemBinding: ViewDataBinding) :
    BaseViewHolder<CarouselRecyclerItem>(itemBinding.root) {


    init {
        itemBinding.root.findViewById<RecyclerView?>(R.id.carouselRecyclerView)?.let {
            PagerSnapHelper().apply { attachToRecyclerView(it) }
        }
    }

    override fun bindData(data: CarouselRecyclerItem, position: Int) {
        itemBinding.setVariable(BR.item, data)
        itemBinding.executePendingBindings()
    }
}