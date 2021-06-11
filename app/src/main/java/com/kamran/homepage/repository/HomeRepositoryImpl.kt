package com.kamran.homepage.repository

import com.kamran.base.BaseRecyclerItem
import com.kamran.homepage.dataprovider.HomeItemDataProvider
import com.kamran.homepage.model.Child

class HomeRepositoryImpl(private val homeItemDataProvider: HomeItemDataProvider) : HomeRepository {

    override suspend fun getHomeData(): ArrayList<BaseRecyclerItem> =
        homeItemDataProvider.getHomeData()

}