package com.heba.mapd713.patient.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseEmptyWrapper(
    val message: String,
)
