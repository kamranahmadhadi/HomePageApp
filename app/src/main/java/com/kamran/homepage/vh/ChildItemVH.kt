package com.kamran.homepage.vh

import androidx.databinding.ViewDataBinding
import com.kamran.base.BaseViewHolder
import com.kamran.homepage.BR
import com.kamran.homepage.model.item.ChildRecyclerItem

class ChildItemVH(private val itemBinding: ViewDataBinding) :
    BaseViewHolder<ChildRecyclerItem>(itemBinding.root) {

    override fun bindData(data: ChildRecyclerItem, position: Int) {
        itemBinding.setVariable(BR.item, data)
        itemBinding.executePendingBindings()
    }
}