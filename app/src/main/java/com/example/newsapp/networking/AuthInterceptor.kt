package com.example.newsapp.networking

import com.example.newsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    private val APIKEY = BuildConfig.API_KEY
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl.newBuilder().addQueryParameter("apikey", APIKEY).build()
        val newRequest = originalRequest.newBuilder().url(newUrl).build()

        return chain.proceed(newRequest)
    }
}