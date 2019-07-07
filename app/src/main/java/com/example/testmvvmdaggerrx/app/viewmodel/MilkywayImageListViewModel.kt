package com.example.testmvvmdaggerrx.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testmvvmdaggerrx.app.DataLoadingState
import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import com.example.testmvvmdaggerrx.data.repository.NasaImagesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MilkywayImageListViewModel @Inject constructor(private val nasaImagesRepository: NasaImagesRepository): ViewModel() {

    val milkywayImageList = MutableLiveData<List<MilkywayImage>>()
    val dataState = MutableLiveData<DataLoadingState>()
    val message = MutableLiveData<String>()
    private lateinit var subscription: Disposable

    fun loadMilkywayImages(keywords: String, yearStart: Int, yearEnd: Int){
        subscription = nasaImagesRepository.getMilkywayImages(keywords, yearStart, yearEnd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{ onLoadList() }
            .subscribe (
                { result -> onFetchListSuccess(result) },
                { result -> onFetchListError() })
    }

    private fun onLoadList() {
        dataState.value = DataLoadingState.LOADING
    }

    private fun onFetchListSuccess(imageList: List<MilkywayImage>){
        dataState.value = DataLoadingState.LOADED
        milkywayImageList.value = imageList
    }

    private fun onFetchListError(){
        dataState.value = DataLoadingState.FAILED
        message.value = "Error fetching images"
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}