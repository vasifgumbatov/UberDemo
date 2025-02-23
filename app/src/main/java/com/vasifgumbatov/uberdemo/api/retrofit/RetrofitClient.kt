package com.vasifgumbatov.uberdemo.api.retrofit

import com.vasifgumbatov.uberdemo.api.service.ApiService
import com.vasifgumbatov.uberdemo.interceptor.BasicAuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://stage.achareh.ir/api/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(BasicAuthInterceptor())
        .build()

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}