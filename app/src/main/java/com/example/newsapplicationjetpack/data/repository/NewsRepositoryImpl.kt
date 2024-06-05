package com.example.newsapplicationjetpack.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapplicationjetpack.data.remote.NewsApi
import com.example.newsapplicationjetpack.data.remote.NewsPagingSource
import com.example.newsapplicationjetpack.data.remote.SearchNewsPagingSource
import com.example.newsapplicationjetpack.domain.models.Article
import com.example.newsapplicationjetpack.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsApi:NewsApi) :NewsRepository{
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
        return  Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    source = source.joinToString(separator = ",")

                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, source: List<String>): Flow<PagingData<Article>> {
        return  Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    newsApi = newsApi,
                    searchQuery= searchQuery,
                    source = source.joinToString(separator = ",")
                )
            }
        ).flow
    }


}