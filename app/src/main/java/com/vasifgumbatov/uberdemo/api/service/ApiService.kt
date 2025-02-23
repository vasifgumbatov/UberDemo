package com.vasifgumbatov.uberdemo.api.service

import com.vasifgumbatov.uberdemo.api.model.Address
import com.vasifgumbatov.uberdemo.api.model.AddressResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("karfarmas/address")
    fun addAddress(
        @Body address: Address,
    ): Call<AddressResponse>

    @GET("karfarmas/address")
    fun getAddresses(): Call<List<Address>>
}