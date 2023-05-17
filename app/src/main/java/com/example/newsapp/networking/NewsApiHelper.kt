package com.example.newsapp.networking

import com.example.newsapp.data.TopHeadlines

interface NewsApiHelper {
    suspend fun getTopHeadlines(): TopHeadlines
}