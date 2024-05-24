package com.example.newsapplicationjetpack.domain.userCases.news

import androidx.paging.PagingData
import com.example.newsapplicationjetpack.domain.models.Article
import com.example.newsapplicationjetpack.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository:NewsRepository
) {
    operator  fun invoke(source: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(source = source)
    }
}