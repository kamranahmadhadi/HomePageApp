package com.kamran.homepage.dataprovider

import android.app.Application
import com.kamran.base.BaseRecyclerItem
import com.kamran.constant.ITEM_TYPE_CAROUSEL
import com.kamran.constant.ITEM_TYPE_GRID
import com.kamran.homepage.R
import com.kamran.homepage.model.*
import com.kamran.homepage.model.item.CarouselRecyclerItem
import com.kamran.homepage.model.item.ChildRecyclerItem
import com.kamran.homepage.model.item.TitleRecyclerItem
import com.kamran.utility.getStringFromAssets
import com.kamran.utility.gson

class HomeItemDataProviderImpl(private val app: Application) : HomeItemDataProvider {

    override suspend fun getHomeData(): ArrayList<BaseRecyclerItem> {
        val response = app.applicationContext.getStringFromAssets("home_response")

        if (response.isNullOrEmpty())
            throw Exception("Raw Response is Null or Empty")

        val homeResponse: HomeResponse = gson.fromJson(response, HomeResponse::class.java)
            ?: throw Exception("Home Response is Null or Empty")

        val resultList: ArrayList<Result>? = homeResponse.result

        if (resultList.isNullOrEmpty())
            throw Exception("Result is Null or Empty")

        val homeRecyclerItem: ArrayList<BaseRecyclerItem> = ArrayList()

        resultList.forEach { result ->
            if (!result.title.isNullOrEmpty()) {
                homeRecyclerItem.add(TitleRecyclerItem(result.title, R.layout.layout_title_item))
            }

            if (result.itemType == ITEM_TYPE_GRID) {
                result.children?.forEach { child ->
                    homeRecyclerItem.add(
                        ChildRecyclerItem(
                            child,
                            R.layout.layout_child_item,
                            result.column
                        )
                    )
                }

            } else if (result.itemType == ITEM_TYPE_CAROUSEL) {
                val childrenRecyclerItem: ArrayList<BaseRecyclerItem> = ArrayList()
                result.children?.forEach { child ->
                    childrenRecyclerItem.add(
                        ChildRecyclerItem(
                            child,
                            R.layout.layout_banner_item
                        )
                    )
                }

                if (childrenRecyclerItem.isNotEmpty()) {
                    homeRecyclerItem.add(
                        CarouselRecyclerItem(
                            childrenRecyclerItem,
                            R.layout.layout_carousel_item
                        )
                    )
                }
            }

        }

        if (homeRecyclerItem.isEmpty())
            throw Exception("Recycler Item is Empty")

        return homeRecyclerItem
    }
}