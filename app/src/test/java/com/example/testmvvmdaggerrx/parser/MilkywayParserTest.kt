package com.example.testmvvmdaggerrx.parser

import android.net.Uri
import com.example.testmvvmdaggerrx.app.utils.DateUtils
import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import com.example.testmvvmdaggerrx.data.common.JSON
import com.example.testmvvmdaggerrx.data.common.jsonArrayOrNull
import com.example.testmvvmdaggerrx.data.parser.MilkywayImageJsonParser
import com.example.testmvvmdaggerrx.utils.getJsonFromJsonFile
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class MilkywayParserTest {

    val milkywayImageJsonParser = MilkywayImageJsonParser()
    lateinit var json: JSON
    lateinit var links : JSONArray
    var data : JSONObject? = null
    lateinit var expectedImage : MilkywayImage

    @Before
    fun setUp(){
        expectedImage = MilkywayImage(
            "A monster in the Milky Way",
            "GSFC_20171208_Archive_e001362",
            "GSFC",
            "This image shows the star-studded center of the Milky Way towards the constellation of Sagittarius. The crowded center of our galaxy contains numerous complex and mysterious objects that are usually hidden at optical wavelengths by clouds of dust — but many are visible here in these infrared observations from Hubble.  However, the most famous cosmic object in this image still remains invisible: the monster at our galaxy’s heart called Sagittarius A*. Astronomers have observed stars spinning around this supermassive black hole (located right in the center of the image), and the black hole consuming clouds of dust as it affects its environment with its enormous gravitational pull.  Infrared observations can pierce through thick obscuring material to reveal information that is usually hidden to the optical observer. This is the best infrared image of this region ever taken with Hubble, and uses infrared archive data from Hubble’s Wide Field Camera 3, taken in September 2011.     Credit: NASA, ESA, and G. Brammer <b><a href=\"http://www.nasa.gov/audience/formedia/features/MP_Photo_Guidelines.html\" rel=\"nofollow\">NASA image use policy.</a></b>  <b><a href=\"http://www.nasa.gov/centers/goddard/home/index.html\" rel=\"nofollow\">NASA Goddard Space Flight Center</a></b> enables NASA’s mission through four scientific endeavors: Earth Science, Heliophysics, Solar System Exploration, and Astrophysics. Goddard plays a leading role in NASA’s accomplishments by contributing compelling scientific knowledge to advance the Agency’s mission.  <b>Follow us on <a href=\"http://twitter.com/NASA_GoddardPix\" rel=\"nofollow\">Twitter</a></b>  <b>Like us on <a href=\"http://www.facebook.com/pages/Greenbelt-MD/NASA-Goddard/395013845897?ref=tsd\" rel=\"nofollow\">Facebook</a></b>  <b>Find us on <a href=\"http://instagram.com/nasagoddard?vm=grid\" rel=\"nofollow\">Instagram</a></b>",
            DateUtils.getDateFromString("2017-12-08"),
            Uri.parse("https://images-assets.nasa.gov/image/GSFC_20171208_Archive_e001362/GSFC_20171208_Archive_e001362~thumb.jpg")
        )
        json = getJsonFromJsonFile("MilkywayJson")

        links = json.jsonObject.getJSONArray("links")
        data = json.jsonArrayOrNull("data")?.getJSONObject(0)
    }

    @Test
    fun testImageParsing(){
        val milkywayImage = milkywayImageJsonParser.parse(json)
        Assert.assertEquals(expectedImage, milkywayImage)
    }

}