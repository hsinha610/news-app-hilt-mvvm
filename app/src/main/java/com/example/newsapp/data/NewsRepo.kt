package com.example.newsapp.data

import com.example.newsapp.networking.NewsApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepo @Inject constructor(private val apiHelper: NewsApiHelper) {

    suspend fun getNewsHeadlines(): TopHeadlines {
        return withContext(Dispatchers.IO) {
            apiHelper.getTopHeadlines()
        }
    }
}