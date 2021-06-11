package com.kamran.homepage.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Child(
    @SerializedName("childId")
    val childId: String?,
    @SerializedName("childPosition")
    val childPosition: String?,
    @SerializedName("childTitle")
    val childTitle: String?,
    @SerializedName("imageUrl")
    val imageUrl: String?
): Parcelable