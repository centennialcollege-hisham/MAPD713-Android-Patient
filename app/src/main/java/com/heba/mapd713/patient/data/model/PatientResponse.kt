package com.heba.mapd713.patient.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class PatientResponse(
    @Json(name = "condition")
    val condition: String? = null,

    @Json(name = "_id")
    val id: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "address")
    val address: String? = null,

    @Json(name = "mobile")
    val mobile: String? = null,

    @Json(name = "email")
    val email: String? = null,

    @Json(name = "birthdate")
    val birthdate: String? = null,

    @Json(name = "gender")
    val gender: String? = null,

    @Json(name = "photo")
    val photo: String? = null,

    @Json(name = "tests")
    val tests: List<TestResponse>? = null,

    @Json(name = "createdAt")
    val createdAt: String? = null,

    @Json(name = "updatedAt")
    val updatedAt: String? = null


) : Parcelable {
    val image = "";
}