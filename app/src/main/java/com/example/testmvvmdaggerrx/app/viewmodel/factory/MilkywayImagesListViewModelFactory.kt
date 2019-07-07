package com.example.testmvvmdaggerrx.app.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testmvvmdaggerrx.app.viewmodel.MilkywayImageListViewModel
import com.example.testmvvmdaggerrx.data.repository.NasaImagesRepository
import javax.inject.Singleton

@Singleton
class MilkywayImagesListViewModelFactory(private val nasaImagesRepository: NasaImagesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MilkywayImageListViewModel(
        nasaImagesRepository
    ) as T

}