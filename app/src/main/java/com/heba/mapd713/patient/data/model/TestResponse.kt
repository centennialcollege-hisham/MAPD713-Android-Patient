package com.heba.mapd713.patient.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
class TestResponse(
    @Json(name = "_id")
    val id: String? = null,

    @Json(name = "date")
    val date: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "reading")
    val value: String? = null
) : Parcelable