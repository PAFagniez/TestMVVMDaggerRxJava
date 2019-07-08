package com.example.testmvvmdaggerrx.app.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.getString(): String = SimpleDateFormat("yyyy-MM-dd").format(this)

