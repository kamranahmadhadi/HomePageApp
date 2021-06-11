package com.kamran.homepage.view

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.kamran.base.BaseActivity
import com.kamran.base.BaseRecyclerItem
import com.kamran.common.CommonRecycleAdapter
import com.kamran.common.Response
import com.kamran.constant.MAX_SPAN
import com.kamran.factory.ViewHolderFactory
import com.kamran.factory.ViewModelFactory
import com.kamran.homepage.R
import com.kamran.homepage.databinding.HomeBinding
import com.kamran.homepage.vm.HomeViewModel

class HomeActivity : BaseActivity<HomeBinding>() {

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(application)).get(HomeViewModel::class.java)
    }

    override fun getLayout(): Int = R.layout.activity_home

    override fun setupObservers() {}

    override fun bindView() {

        homeViewModel.getHomeData().observe(this, { response ->
            when (response) {

                is Response.Loading -> {
                    //TODO SHOW Progress
                }

                is Response.Success -> {
                    //TODO HIDE Progress
                    Log.d("KAM_LOG", "TH=${Thread.currentThread().name}")
                    binding.item = homeViewModel

                }

                is Response.Failure -> {
                    //TODO HIDE Progress
                    response.message
                }
            }
        })
    }
}