package com.example.newsapplicationjetpack.data.remote.dto

import com.example.newsapplicationjetpack.domain.models.Article

// data transfer object
data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

