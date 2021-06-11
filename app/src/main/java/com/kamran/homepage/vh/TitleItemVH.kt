package com.kamran.homepage.vh

import androidx.databinding.ViewDataBinding
import com.kamran.base.BaseViewHolder
import com.kamran.homepage.BR
import com.kamran.homepage.model.item.TitleRecyclerItem

class TitleItemVH(private val itemBinding: ViewDataBinding) :
    BaseViewHolder<TitleRecyclerItem>(itemBinding.root) {

    override fun bindData(data: TitleRecyclerItem, position: Int) {
        itemBinding.setVariable(BR.item, data)
        itemBinding.executePendingBindings()
    }
}