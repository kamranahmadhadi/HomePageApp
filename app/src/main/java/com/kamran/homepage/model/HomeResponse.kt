package com.kamran.homepage.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeResponse(
    @SerializedName("result")
    val result: ArrayList<Result>?,
    @SerializedName("status")
    val status: Int?
): Parcelable