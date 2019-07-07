package com.example.testmvvmdaggerrx.domain.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NasaImageService {
    @GET("search")
    fun getMilkywayImages(@QueryMap params:  Map<String, String> ): Call<String>

}