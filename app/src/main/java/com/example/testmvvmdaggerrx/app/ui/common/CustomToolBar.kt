package com.example.testmvvmdaggerrx.app.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.testmvvmdaggerrx.R
import com.example.testmvvmdaggerrx.app.utils.WeakReference
import kotlinx.android.synthetic.main.toolbar_view.view.*

interface OnClickBackToolbarListener {
    fun onClickBackMenuListener()
}

class CustomToolBar(context: Context, attrs: AttributeSet?): Toolbar(context, attrs) {

    private var backListener: OnClickBackToolbarListener? by WeakReference()

    init {
        View.inflate(context, R.layout.toolbar_view, this)
        iconBack.setOnClickListener { backListener?.onClickBackMenuListener() }
    }

    fun setBackListener(listener: OnClickBackToolbarListener): CustomToolBar{
        this.backListener = listener
        return this
    }

}