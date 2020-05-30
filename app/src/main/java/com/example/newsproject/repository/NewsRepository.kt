package com.example.newsproject.repository

import com.example.newsproject.model.News
import com.example.newsproject.webservice.NewsWebservice

class NewsRepository (private val webservice: NewsWebservice) {

    suspend fun getNews(type: String): List<News>? {

        val result = webservice.getNews(type)

        val list: List<News>?
        list = if (result.isSuccessful) {

            result.body()?.list
        } else {

            null
        }

        return list
    }
}