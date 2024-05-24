package com.example.newsapplicationjetpack.domain.repository

import androidx.paging.PagingData
import com.example.newsapplicationjetpack.data.remote.NewsApi
import com.example.newsapplicationjetpack.data.remote.dto.NewsResponse
import com.example.newsapplicationjetpack.domain.models.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


//class NewsRepository @Inject constructor(private val newsApi: NewsApi) {
//
//    private val _news = MutableStateFlow<List<Article>>(emptyList())
//    val news :StateFlow<List<Article>>
//        get() = _news
//    suspend fun getNews(apiKey:String, category:String ){
//        val response = newsApi.getNewsHeadlines(apiKey, category)
//
//        if (response.isSuccessful && response.body() != null){
//
//            _news.emit(response.body()!!.articles)
//        }
//    }
//}


interface NewsRepository {

    fun getNews(source :List <String>) : Flow<PagingData<Article>>

}
