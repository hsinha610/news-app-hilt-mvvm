package com.example.newsapp.networking

import com.example.newsapp.data.TopHeadlines
import javax.inject.Inject

class NewsApiHelperImpl @Inject constructor(private val apiService: NewsApiService) :
    NewsApiHelper {
    override suspend fun getTopHeadlines(): TopHeadlines =
        apiService.getTopHeadlines()

}