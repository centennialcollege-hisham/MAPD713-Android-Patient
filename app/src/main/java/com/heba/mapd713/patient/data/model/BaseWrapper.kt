package com.heba.mapd713.patient.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseWrapper<T>(
    val message: String,
    val data: T
)
