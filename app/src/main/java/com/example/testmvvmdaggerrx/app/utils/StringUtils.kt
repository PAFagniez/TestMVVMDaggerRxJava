package com.example.testmvvmdaggerrx.app.utils

import android.text.Html

object StringUtils {

    fun fromHtml(str: String): String {
        val result: String = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Html.fromHtml(str, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(str).toString()
        }
        return result
    }
}