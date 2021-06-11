package com.kamran.homepage.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    @SerializedName("children")
    val children: ArrayList<Child>?,
    @SerializedName("itemId")
    val itemId: String?,
    @SerializedName("itemPosition")
    val itemPosition: String?,
    @SerializedName("itemType")
    val itemType: String?,
    @SerializedName("numberOfColumns")
    val numberOfColumns: String?,
    @SerializedName("title")
    val title: String?
): Parcelable {
    val column: Int get() = if (numberOfColumns.isNullOrEmpty()) 1 else numberOfColumns.toInt()
}