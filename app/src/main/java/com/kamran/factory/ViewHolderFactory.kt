package com.kamran.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kamran.base.BaseViewHolderFactory
import com.kamran.base.RecyclerViewHolder
import com.kamran.homepage.R
import com.kamran.homepage.vh.CarouselItemVH
import com.kamran.homepage.vh.ChildItemVH
import com.kamran.homepage.vh.TitleItemVH

object ViewHolderFactory : BaseViewHolderFactory() {

    override fun getViewHolder(vhType: Int, parent: ViewGroup): RecyclerViewHolder {

        val viewBinding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            vhType,
            parent, false
        )

        return when (vhType) {
            R.layout.layout_title_item -> {
                TitleItemVH(viewBinding)
            }
            R.layout.layout_child_item,
            R.layout.layout_banner_item -> {
                ChildItemVH(viewBinding)
            }
            R.layout.layout_carousel_item -> {
                CarouselItemVH(viewBinding)
            }
            else -> {
                throw Exception("Invalid View Type is passed")
            }
        }
    }
}