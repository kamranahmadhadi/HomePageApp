package com.kamran.common

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kamran.base.BaseRecyclerItem
import com.kamran.base.BaseViewHolderFactory
import com.kamran.base.RecyclerItemClickListener
import com.kamran.base.RecyclerViewHolder

class CommonRecycleAdapter<ITEM : BaseRecyclerItem>(
    items: ArrayList<ITEM>?,
    private val vhFactory: BaseViewHolderFactory,
    private val itemClickListener: RecyclerItemClickListener? = null
) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    private val itemList: ArrayList<ITEM> = ArrayList()

    init {
        items?.let { itemList.addAll(it) }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].itemLayout
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHolder {
        return vhFactory.getViewHolder(viewType, parent)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        itemList[position].position = position
        itemList[position].itemClickListener = itemClickListener
        itemList[position].onBindItem(holder, position)
    }

    fun addFirstItem(item: ITEM) {
        itemList.add(0, item)
        notifyItemInserted(0)
    }

    fun addItem(item: ITEM) {
        itemList.add(item)
        notifyItemInserted(itemList.size - 1)
    }

    fun addItem(position: Int, item: ITEM) {
        var index = itemList.size - 1
        if (itemList.size > position)
            index = position

        itemList.add(index, item)
        notifyItemInserted(index)
    }

    fun replaceAllItem(itemList: ArrayList<ITEM>) {
        this.itemList.clear()
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun mergeItems(itemList: ArrayList<ITEM>) {
        this.itemList.addAll(itemList)
        notifyItemRangeInserted(this.itemList.size, itemList.size)
    }

    fun removeItem(position: Int) {
        if (position > -1 && itemList.size > position) {
            this.itemList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun removeItem(item: ITEM) {
        removeItem(this.itemList.indexOf(item))
    }

    fun removeAllItem() {
        this.itemList.clear()
        notifyDataSetChanged()
    }

    fun updateItem(position: Int, item: ITEM) {
        this.itemList[position] = item
        notifyItemChanged(position)
    }

    fun updateItems(position: Int, previousPosition: Int, item: ITEM, prevItem: ITEM) {
        this.itemList[position] = item
        this.itemList[previousPosition] = prevItem

        if (previousPosition > position)
            notifyItemRangeChanged(position, previousPosition + 1)
        else if (previousPosition < position)
            notifyItemRangeChanged(previousPosition, position + 1)
    }

    override fun onViewAttachedToWindow(holder: RecyclerViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.onViewAttachedToWindow()
        Log.d("KAM_REC", "Attach= ${holder.hashCode()}")
    }

    override fun onViewDetachedFromWindow(holder: RecyclerViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.onViewDetachedFromWindow()
        Log.d("KAM_REC", "Detach= ${holder.hashCode()}, POS= ${holder.itemViewType}")
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val layoutManager = recyclerView.layoutManager
        if (layoutManager is GridLayoutManager)
            layoutManager.spanSizeLookup = getSpanSizeLookup()
    }

    private fun getSpanSizeLookup(): GridLayoutManager.SpanSizeLookup {
        return object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return itemList[position].getSpan()
            }
        }
    }
}