package com.example.newsapp.data

import com.google.gson.annotations.SerializedName

data class TopHeadlines(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val listOfArticles: List<Article>
)

data class Article(
    val author: String,
    val title: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
)
