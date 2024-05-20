package com.example.newsapplicationjetpack.api

import com.example.newsapplicationjetpack.models.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines?country=In")
    suspend fun getNewsHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("category") category: String
    ): Response<DataModel>

}