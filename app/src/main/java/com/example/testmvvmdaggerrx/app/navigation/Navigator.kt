package com.example.testmvvmdaggerrx.app.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.testmvvmdaggerrx.R
import com.example.testmvvmdaggerrx.app.ui.MainActivity
import com.example.testmvvmdaggerrx.app.ui.milkywayimages.fragment.MilkywayImageFragment
import com.example.testmvvmdaggerrx.app.ui.milkywayimages.fragment.MilkywayImageListFragment
import com.example.testmvvmdaggerrx.core.model.MilkywayImage

interface MilkywayImageListNavigator {

    fun <T>T.navigateToMilkywayImageList() where T: FragmentActivity {
        navigateToMilkywayList(this)
    }

    fun navigateToMilkywayList(activity: FragmentActivity) {
        activity.switchToFragment(MilkywayImageListFragment())
    }
}

interface MilkywayImageDetailsNavigator {
    fun <T>T.navigateToMilkywayImageDetails(image: MilkywayImage) where T: FragmentActivity {
        navigateToMilkywayImageDetails(image, this)
    }

    fun navigateToMilkywayImageDetails(image: MilkywayImage, activity: FragmentActivity) {
        val fragment = prepareArticleFrag(image)

        activity.switchToFragment(fragment)
    }

    private fun prepareArticleFrag(image: MilkywayImage) : MilkywayImageFragment {
        val fragment = MilkywayImageFragment()
        val args = Bundle()
        args.putParcelable(MainActivity.MILKYWAY_IMAGE_KEY, image)

        fragment.arguments = args
        return fragment
    }
}

fun <T> T.switchToFragment(fragment: Fragment, args: Bundle? = null) where T : FragmentActivity {
    args?.let { fragment.arguments = it }
    this.supportFragmentManager.beginTransaction()
        .replace(R.id.fragmentContainer, fragment)
        .addToBackStack(null)
        .commit()
}

