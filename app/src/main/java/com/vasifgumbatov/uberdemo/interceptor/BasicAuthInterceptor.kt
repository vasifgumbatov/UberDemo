package com.vasifgumbatov.uberdemo.interceptor

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor: Interceptor {

    private val credentials = Credentials.basic("09822222222", "Sana12345678")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", credentials)
            .build()
        return chain.proceed(request)
    }
}