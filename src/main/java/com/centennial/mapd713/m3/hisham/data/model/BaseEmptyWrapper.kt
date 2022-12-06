package com.centennial.mapd713.m3.hisham.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseEmptyWrapper(
    val message: String,
)
