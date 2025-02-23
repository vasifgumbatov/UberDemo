package com.vasifgumbatov.uberdemo.api.model

import com.google.gson.annotations.SerializedName

data class Address(
    val region: Int,
    val address: String,
    val lat: Double,
    val lng: Double,
    @SerializedName("coordinate_mobile")
    val coordinateMobile: String,
    @SerializedName("coordinate_phone_number")
    val coordinatePhoneNumber: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val gender: String
)

data class AddressResponse(
    val id: Int,
    val region: Int,
    val address: String,
    val lat: Double,
    val lng: Double,
    @SerializedName("coordinate_mobile")
    val coordinateMobile: String,
    @SerializedName("coordinate_phone_number")
    val coordinatePhoneNumber: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val gender: String,
    val status: String // "Success" or "Error"
)
