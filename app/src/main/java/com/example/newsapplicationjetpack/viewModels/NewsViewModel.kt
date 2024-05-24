package com.example.newsapplicationjetpack.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplicationjetpack.data.remote.dto.NewsResponse
import com.example.newsapplicationjetpack.domain.models.Article
import com.example.newsapplicationjetpack.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) :ViewModel() {

//    val news:StateFlow<List<Article>>
//        get()= repository.news
//
//    init {
//        viewModelScope.launch {
////            repository.getNews()
//        }
//    }


}