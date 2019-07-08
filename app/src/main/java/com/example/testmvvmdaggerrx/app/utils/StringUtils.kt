package com.example.testmvvmdaggerrx.app.utils

import android.os.Build
import android.text.Html

object StringUtils {

    fun fromHtml(str: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(str, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(str).toString()
        }
    }
}