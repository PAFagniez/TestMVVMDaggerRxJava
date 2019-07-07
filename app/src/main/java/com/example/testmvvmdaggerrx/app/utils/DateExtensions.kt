package com.example.testmvvmdaggerrx.app.utils

import android.icu.text.SimpleDateFormat
import java.util.*

fun Date.getString(): String = SimpleDateFormat("yyyy-MM-dd").format(this)

