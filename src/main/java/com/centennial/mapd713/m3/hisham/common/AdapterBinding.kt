package com.centennial.mapd713.m3.hisham.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUri")
fun setImageUri(view: ImageView, imageUri: String?) {
    Glide.with(view.context).load(imageUri).into(view)
}