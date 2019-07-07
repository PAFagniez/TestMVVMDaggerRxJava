package com.example.testmvvmdaggerrx.app.utils

import java.text.SimpleDateFormat

object DateUtils {

    fun getDateFromString(string: String) = SimpleDateFormat("yyyy-MM-dd").parse(string)
}

