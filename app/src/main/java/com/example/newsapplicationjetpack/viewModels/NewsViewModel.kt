package com.example.newsapplicationjetpack.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplicationjetpack.models.DataModel
import com.example.newsapplicationjetpack.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) :ViewModel() {

    val news:StateFlow<List<DataModel.Article>>
        get()= repository.news

    init {
        viewModelScope.launch {
//            repository.getNews()
        }
    }


}