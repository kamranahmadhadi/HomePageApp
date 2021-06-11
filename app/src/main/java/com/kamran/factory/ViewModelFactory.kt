package com.kamran.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kamran.homepage.dataprovider.HomeItemDataProviderImpl
import com.kamran.homepage.repository.HomeRepositoryImpl
import com.kamran.homepage.vm.HomeViewModel

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(viewModelClass: Class<T>): T {
        return when {
            viewModelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(HomeRepositoryImpl(HomeItemDataProviderImpl(application))) as T
            }
            else -> throw IllegalArgumentException("Unknown View Model class name")
        }
    }
}