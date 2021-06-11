package com.kamran.homepage.vm

import androidx.lifecycle.liveData
import com.kamran.base.BaseRecyclerItem
import com.kamran.base.BaseViewModel
import com.kamran.common.Response
import com.kamran.homepage.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class HomeViewModel(private val homeRepository: HomeRepository) : BaseViewModel() {

    var itemList: ArrayList<BaseRecyclerItem>? = null
        private set

    fun getHomeData() = liveData<Response<ArrayList<BaseRecyclerItem>>>(Dispatchers.IO) {
        try {
            itemList = homeRepository.getHomeData()
            emit(Response.Success(itemList!!))
        } catch (ex: Exception) {
            emit(Response.Failure(ex.message))
        }
    }
}