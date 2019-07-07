package com.example.testmvvmdaggerrx.data.parser

import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import com.example.testmvvmdaggerrx.data.common.JSON
import com.example.testmvvmdaggerrx.data.common.JSONParser
import com.example.testmvvmdaggerrx.data.common.invoke
import java.util.*

class MilkywayImageListJsonParser: JSONParser<List<MilkywayImage>> {

    override fun parse(json: JSON): List<MilkywayImage> {
        val collection = json("collection") ?: json
        val items = collection.jsonObject.getJSONArray("items")

        val models = ArrayList<MilkywayImage>()
        for (i in 0 until items.length()) {
            val entryJSON = JSON(items.getJSONObject(i))
            val model = MilkywayImageJsonParser().parse(entryJSON)
            model.let { models.add(it) }
        }

        return models
    }
}