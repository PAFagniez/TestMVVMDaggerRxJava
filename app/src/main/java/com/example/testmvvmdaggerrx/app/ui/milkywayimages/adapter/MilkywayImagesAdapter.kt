package com.example.testmvvmdaggerrx.app.ui.milkywayimages.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.testmvvmdaggerrx.R
import com.example.testmvvmdaggerrx.app.utils.WeakReference
import com.example.testmvvmdaggerrx.app.utils.getString
import com.example.testmvvmdaggerrx.core.model.MilkywayImage
import kotlinx.android.synthetic.main.milkyway_image_item_view.view.*


class MilkywayImageAdapter: Adapter<MilkywayImageViewHolder>(),
    MilkywayImageViewHolder.Listener {

    interface Listener {
        fun onClickItemInList(article: MilkywayImage)
    }

    private var imageList: List<MilkywayImage>? = null
    var delegate: Listener? by WeakReference()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MilkywayImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.milkyway_image_item_view, parent, false)
        return MilkywayImageViewHolder(view)
    }

    override fun getItemCount() = imageList?.size ?: 0

    override fun onBindViewHolder(articleView: MilkywayImageViewHolder, position: Int) {
        imageList?.get(position)?.let {
            articleView.bind(it)
            articleView.delegate = this
        }
    }

    override fun onClickArticle(milkywayImage: MilkywayImage) {
        delegate?.onClickItemInList(milkywayImage)
    }

    fun setItems(list: List<MilkywayImage>) {
        imageList = list
        notifyDataSetChanged()
    }
}

class MilkywayImageViewHolder(view: View): RecyclerView.ViewHolder(view) {

    interface Listener {
        fun onClickArticle(milkywayImage: MilkywayImage)
    }

    var delegate: Listener? by WeakReference()

    fun bind(milkywayImage: MilkywayImage){
        val dateStr = milkywayImage.date?.getString()

        itemView.apply {
            Glide.with(this).load(milkywayImage.imageUri).into(imageIV)
            imageTitleTV.text = milkywayImage.title
            imageInfoTV.text = "${milkywayImage.center}  |  $dateStr"

            setOnClickListener { delegate?.onClickArticle(milkywayImage) }
        }
    }
}
