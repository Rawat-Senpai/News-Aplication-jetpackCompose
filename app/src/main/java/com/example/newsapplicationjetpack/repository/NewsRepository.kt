package com.example.newsapplicationjetpack.repository

import com.example.newsapplicationjetpack.api.NewsApi
import com.example.newsapplicationjetpack.models.DataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    private val _news = MutableStateFlow<List<DataModel.Article>>(emptyList())
    val news :StateFlow<List<DataModel.Article>>
        get() = _news
    suspend fun getNews(apiKey:String, category:String ){
        val response = newsApi.getNewsHeadlines(apiKey, category)

        if (response.isSuccessful && response.body() != null){

            _news.emit(response.body()!!.articles)


        }

    }


}