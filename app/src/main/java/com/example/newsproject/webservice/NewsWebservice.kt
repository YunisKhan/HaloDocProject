package com.example.newsproject.webservice

import com.example.newsproject.model.Hits
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsWebservice {

    @GET("/search")
    suspend fun getNews(@Query("query") value: String): Response<Hits>
}