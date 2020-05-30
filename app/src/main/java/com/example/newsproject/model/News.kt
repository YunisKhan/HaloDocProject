package com.example.newsproject.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hits(

    @Json(name = "hits")
    val list: List<News>
)

@JsonClass(generateAdapter = true)
data class News (

    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "author")
    val author: String,
    @Json(name = "url")
    val url: String
)