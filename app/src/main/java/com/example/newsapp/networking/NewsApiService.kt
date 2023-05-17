package com.example.newsapp.networking

import com.example.newsapp.data.TopHeadlines
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("category") category: String = "technology",
        @Query("country") country: String = "us",
        @Query("pageSize") itemsPerPage: Int = 100,
        @Query("page") page: Int = 1
    ): TopHeadlines
}