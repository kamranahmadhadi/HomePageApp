package com.kamran.homepage.model.item

import com.kamran.base.BaseRecyclerItem
import com.kamran.base.RecyclerViewHolder
import com.kamran.homepage.model.Child
import com.kamran.homepage.vh.CarouselItemVH

class CarouselRecyclerItem(
    val itemData: ArrayList<BaseRecyclerItem>,
    override val itemLayout: Int,
    override val numberOfColumns: Int = 1
) : BaseRecyclerItem() {

    val isHorizontalScroll = true
    val isLinearLayoutManger = true

    override fun onBindItem(holder: RecyclerViewHolder, position: Int) {
        (holder as CarouselItemVH).bindData(this, position)
    }


}