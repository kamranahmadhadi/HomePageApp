package com.kamran.utility

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kamran.base.BaseRecyclerItem
import com.kamran.common.CommonRecycleAdapter
import com.kamran.constant.MAX_SPAN
import com.kamran.factory.ViewHolderFactory

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView);
    }
}

@BindingAdapter(
    value = ["bindItems", "isLinearLayoutManger", "isHorizontalScroll", "maxSpanCount"],
    requireAll = false
)
fun bindRecyclerViewItems(
    view: RecyclerView,
    bindItems: ArrayList<BaseRecyclerItem>?,
    isLinearLayoutManger: Boolean,
    isHorizontalScroll: Boolean,
    maxSpanCount: Int?
) {
    if (bindItems.isNullOrEmpty())
        return

    if (view.layoutManager == null) {
        if (isLinearLayoutManger)
            view.layoutManager = LinearLayoutManager(
                view.context,
                if (isHorizontalScroll) LinearLayoutManager.HORIZONTAL else LinearLayoutManager.VERTICAL,
                false
            )
        else
            view.layoutManager = GridLayoutManager(view.context, maxSpanCount ?: MAX_SPAN)
    }
    if (view.adapter == null) {
        view.adapter = CommonRecycleAdapter(bindItems, ViewHolderFactory)
    } else if (view.adapter is CommonRecycleAdapter<*>) {
        @Suppress("UNCHECKED_CAST")
        val recyclerAdapter = view.adapter as CommonRecycleAdapter<BaseRecyclerItem>
        recyclerAdapter.replaceAllItem(bindItems)
    }

}