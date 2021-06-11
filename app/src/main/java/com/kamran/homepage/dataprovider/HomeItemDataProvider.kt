package com.kamran.homepage.dataprovider

import com.kamran.base.BaseRecyclerItem

interface HomeItemDataProvider {
    suspend fun getHomeData():ArrayList<BaseRecyclerItem>
}