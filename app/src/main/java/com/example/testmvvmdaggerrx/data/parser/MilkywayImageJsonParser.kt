package com.example.testmvvmdaggerrx.data.parser

import android.net.Uri
import com.example.testmvvmdaggerrx.app.utils.DateUtils
import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import com.example.testmvvmdaggerrx.data.common.JSON
import com.example.testmvvmdaggerrx.data.common.JSONParser
import com.example.testmvvmdaggerrx.data.common.jsonArrayOrNull
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MilkywayImageJsonParser: JSONParser<MilkywayImage> {

    private var title: String? = null
    private var id: String? = null
    private var center: String? = null
    private var description: String? = null
    private var date: Date? = null
    private var imageUri: Uri? = null

    override fun parse(json: JSON): MilkywayImage {
        val links = json.jsonObject.getJSONArray("links")

        imageUri = getImage(links)

        val data = json.jsonArrayOrNull("data")?.getJSONObject(0)

        title = getTitle(data)
        id = getId(data)
        center = getCenter(data)
        description = getDescription(data)
        date = getDate(data)

        return MilkywayImage(title, id, center, description, date, imageUri)
    }

    private fun getImage(links: JSONArray): Uri{
        val link = links.getJSONObject(0)
        val photoUriString = link.getString("href")
        return Uri.parse(photoUriString)
    }

    private fun getTitle(json: JSONObject?): String? = json?.getString("title")

    private fun getId(json: JSONObject?): String? = json?.getString("nasa_id")

    private fun getCenter(json: JSONObject?): String? = json?.getString("center")

    private fun getDescription(json: JSONObject?): String? = json?.getString("description")

    private fun getDate(json: JSONObject?): Date? {
        val dateString = json?.getString("date_created")?.substringBefore("T")
        return dateString?.let { DateUtils.getDateFromString(it) }
    }
}