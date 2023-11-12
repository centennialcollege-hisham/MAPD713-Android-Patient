package com.heba.mapd713.patient.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUri")
fun setImageUri(view: ImageView, imageUri: String?) {
    Glide.with(view.context).load(imageUri).into(view)
}