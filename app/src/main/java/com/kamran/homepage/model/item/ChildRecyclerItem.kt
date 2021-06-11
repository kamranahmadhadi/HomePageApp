package com.kamran.homepage.model.item

import com.kamran.base.BaseRecyclerItem
import com.kamran.base.RecyclerViewHolder
import com.kamran.homepage.model.Child
import com.kamran.homepage.vh.ChildItemVH

class ChildRecyclerItem(
    val itemData: Child,
    override val itemLayout: Int,
    override val numberOfColumns: Int = 1
) : BaseRecyclerItem() {

    override fun onBindItem(holder: RecyclerViewHolder, position: Int) {
        (holder as ChildItemVH).bindData(this, position)
    }
}