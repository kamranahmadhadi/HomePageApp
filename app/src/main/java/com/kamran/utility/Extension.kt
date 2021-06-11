package com.kamran.utility

import android.content.Context
import android.content.res.Resources
import com.google.gson.Gson

fun Context.getStringFromAssets(fileName: String, fileExtension: String = "json"): String? {
    try {
        return applicationContext.assets.open("$fileName.$fileExtension").bufferedReader()
            .use { reader ->
                reader.readText()
            }
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return null
}