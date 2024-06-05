package com.example.newsapplicationjetpack.data.remote

import com.example.newsapplicationjetpack.data.remote.dto.NewsResponse
import com.example.newsapplicationjetpack.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page:Int,
        @Query("sources") source:String,
        @Query("apikey") apiKey: String = Constants.API_KEY
    ) : NewsResponse


    suspend fun searchNews(
        @Query("q") searchQuery:String,
        @Query("page") page:Int,
        @Query("sources") source:String,
        @Query("apikey") apiKey: String = Constants.API_KEY
    ):NewsResponse

}