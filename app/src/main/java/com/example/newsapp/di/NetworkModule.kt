package com.example.newsapp.di

import com.example.newsapp.networking.AuthInterceptor
import com.example.newsapp.networking.NewsApiHelper
import com.example.newsapp.networking.NewsApiHelperImpl
import com.example.newsapp.networking.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://newsapi.org/v2/"

    @Singleton
    @Provides
    fun providesOkhttpClient(authInterceptor: AuthInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(authInterceptor).build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create()
        ).baseUrl(BASE_URL).client(okHttpClient).build()

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)

    @Singleton
    @Provides
    fun provideApiHelper(apiHelper: NewsApiHelperImpl) : NewsApiHelper = apiHelper
}