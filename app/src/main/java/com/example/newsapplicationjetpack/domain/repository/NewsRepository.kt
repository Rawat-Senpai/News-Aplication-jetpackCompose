package com.example.newsapplicationjetpack.domain.repository

import androidx.paging.PagingData
import com.example.newsapplicationjetpack.data.remote.NewsApi
import com.example.newsapplicationjetpack.data.remote.dto.NewsResponse
import com.example.newsapplicationjetpack.domain.models.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject





interface NewsRepository {

    fun getNews(source :List <String>) : Flow<PagingData<Article>>

    fun searchNews(searchQuery:String,source :List <String>) : Flow<PagingData<Article>>

}
