package com.example.testmvvmdaggerrx.utils

import android.util.Log
import com.example.testmvvmdaggerrx.data.common.JSON
import java.io.File

fun Any.getJsonFromJsonFile(name: String): JSON {

    val path = javaClass.classLoader!!.getResource(name)
    val file = File(path.toURI())
    val jsonString = file.readText()
    Log.i("", jsonString)
    return JSON(jsonString)
}