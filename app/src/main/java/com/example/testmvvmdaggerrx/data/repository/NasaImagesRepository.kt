package com.example.testmvvmdaggerrx.data.repository

import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import com.example.testmvvmdaggerrx.data.common.JSON
import com.example.testmvvmdaggerrx.data.parser.MilkywayImageListJsonParser
import com.example.testmvvmdaggerrx.domain.service.NasaImageService
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class NasaImagesRepository(private val service: NasaImageService) {

    fun getMilkywayImages(keyword: String, yearStart: Int, yearEnd: Int): Observable<List<MilkywayImage>> {
        return Observable.create<List<MilkywayImage>> { emitter ->
            val params = HashMap<String, String>()
            params["q"] = keyword
            params["media_type"] = "image"
            params["year_start"] = yearStart.toString()
            params["year_end"] = yearEnd.toString()
            service.getMilkywayImages(params) .enqueue(object : Callback<String>{

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    val json = JSON(response.body())
                    emitter.onNext(MilkywayImageListJsonParser().parse(json))
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    emitter.onError(t)
                }
            })
        }
    }
}