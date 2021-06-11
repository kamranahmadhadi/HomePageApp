package com.kamran.common

sealed class Response<out T> {
    class Success<out T>(val data: T, val message: String? = null) : Response<T>()

    class Failure(val message: String? = null) : Response<Nothing>()

    object Loading : Response<Nothing>()
}
