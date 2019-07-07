package com.example.testmvvmdaggerrx.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testmvvmdaggerrx.R
import com.example.testmvvmdaggerrx.app.navigation.MilkywayImageListNavigator
import com.example.testmvvmdaggerrx.app.navigation.MilkywayImageDetailsNavigator
import com.example.testmvvmdaggerrx.app.ui.milkywayimages.fragment.MilkywayImageFragment
import com.example.testmvvmdaggerrx.app.ui.milkywayimages.fragment.MilkywayImageListFragment
import com.example.testmvvmdaggerrx.core.model.MilkywayImage

class MainActivity : AppCompatActivity(), MilkywayImageListNavigator, MilkywayImageDetailsNavigator,
    MilkywayImageListFragment.Listener, MilkywayImageFragment.Listener {

    companion object {
        const val MILKYWAY_IMAGE_KEY = "MILKYWAY_IMAGE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToMilkywayImageList()
    }

    override fun onItemClicked(milkywayImage: MilkywayImage) {
        navigateToMilkywayImageDetails(milkywayImage)
    }
}
