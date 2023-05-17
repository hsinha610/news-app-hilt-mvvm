package com.example.newsapp.ui

import com.example.newsapp.data.Article

interface ClickInterface {
    fun newsClicked(news: Article)
}