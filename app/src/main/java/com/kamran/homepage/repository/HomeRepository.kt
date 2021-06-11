package com.kamran.homepage.repository

import com.kamran.base.BaseRecyclerItem

interface HomeRepository {
    suspend fun getHomeData():ArrayList<BaseRecyclerItem>
}