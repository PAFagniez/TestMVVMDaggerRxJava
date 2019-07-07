package com.example.testmvvmdaggerrx.app.injection.module

import com.example.testmvvmdaggerrx.app.Environment
import com.example.testmvvmdaggerrx.data.common.ConverterFactory
import com.example.testmvvmdaggerrx.data.repository.NasaImagesRepository
import com.example.testmvvmdaggerrx.domain.service.NasaImageService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton


@Module
object NetworkModule {

    @Provides
    @Singleton
    internal fun provideNasaRepository(nasaImageService: NasaImageService): NasaImagesRepository =
        NasaImagesRepository(nasaImageService)


    @Provides
    @Singleton
    internal fun provideNasaService(retrofit: Retrofit): NasaImageService =
        retrofit.create(NasaImageService::class.java)


    @Provides
    @Singleton
    internal fun providerNasaApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Environment.BASE_NASA_IMAGES_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ConverterFactory())
            .build()
    }
}