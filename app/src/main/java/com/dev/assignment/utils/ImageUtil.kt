package com.dev.assignment.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.dev.assignment.R
import com.squareup.picasso.Picasso

object ImageUtil {


    @JvmStatic
    @BindingAdapter("photoUrl")
    fun loadImage(view: ImageView, photoUrl: String?) {
        Picasso.with(view.context).load(photoUrl).fit().centerCrop()
            .placeholder(R.drawable.image_placeholder)
            .error(R.drawable.image_placeholder)
            .into(view);
    }
}

