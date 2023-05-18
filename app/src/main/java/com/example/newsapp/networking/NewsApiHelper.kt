package com.example.newsapp.networking

import com.example.newsapp.data.TopHeadlines
import javax.inject.Inject

class NewsApiHelper @Inject constructor(private val apiService: NewsApiService) {

    suspend fun getTopHeadlines(): TopHeadlines =
        apiService.getTopHeadlines()

}