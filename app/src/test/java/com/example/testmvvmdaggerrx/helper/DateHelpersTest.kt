package com.example.testmvvmdaggerrx.helper

import com.example.testmvvmdaggerrx.app.utils.DateUtils
import com.example.testmvvmdaggerrx.app.utils.getString
import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat

class DateHelpersTest {

    private val stringToParse = "1795-10-13"

    @Test
    fun testGetDateFromString(){
        val expected = SimpleDateFormat("yyyy-MM-dd").parse(stringToParse)
        val actual = DateUtils.getDateFromString(stringToParse)
        Assert.assertEquals("Dates are different", expected, actual)
    }

    @Test
    fun testGetStringFromDate() {
        val expected = stringToParse
        val actual = SimpleDateFormat("yyyy-MM-dd").parse(stringToParse).getString()
        Assert.assertEquals("Strings are different", expected, actual)
    }

}