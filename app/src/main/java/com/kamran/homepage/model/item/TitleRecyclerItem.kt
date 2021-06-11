package com.kamran.homepage.model.item

import com.kamran.base.BaseRecyclerItem
import com.kamran.base.RecyclerViewHolder
import com.kamran.homepage.vh.TitleItemVH

class TitleRecyclerItem(
    val itemData: String,
    override val itemLayout: Int,
    override val numberOfColumns: Int = 1
) : BaseRecyclerItem() {
    override fun onBindItem(holder: RecyclerViewHolder, position: Int) {
        (holder as TitleItemVH).bindData(this, position)
    }
}