package com.example.testmvvmdaggerrx.app.ui.milkywayimages.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.testmvvmdaggerrx.R
import com.example.testmvvmdaggerrx.app.ui.MainActivity
import com.example.testmvvmdaggerrx.app.ui.common.OnClickBackToolbarListener
import com.example.testmvvmdaggerrx.app.utils.StringUtils
import com.example.testmvvmdaggerrx.app.utils.getString
import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import kotlinx.android.synthetic.main.image_details_view.*

class MilkywayImageFragment: Fragment(), OnClickBackToolbarListener {

    interface Listener {
        fun onBackPressed()
    }

    private var delegate: Listener? = null
    var milkywayImage: MilkywayImage? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            delegate = context as Listener?
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement MilkywayImageFragment.Listener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        milkywayImage = arguments?.getParcelable(MainActivity.MILKYWAY_IMAGE_KEY)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.image_details_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView(){
        toolbar.setBackListener(this)
        milkywayImage?.let {
            Glide.with(this).load(it.imageUri).into(milkywayImageView)
            milkywayTitleView.text = it.title
            milkywayCenterView.text = it.center
            milkywayDateView.text = it.date?.getString()
            it.description?.let { description -> milkywayDescriptionView.text = StringUtils.fromHtml(description) }

        }
    }

    override fun onClickBackMenuListener() {
        delegate?.onBackPressed()
    }
}