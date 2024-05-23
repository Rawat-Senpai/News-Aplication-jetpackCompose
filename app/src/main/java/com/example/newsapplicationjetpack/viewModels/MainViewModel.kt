package com.example.newsapplicationjetpack.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.newsapplicationjetpack.domain.userCases.AppEntryUseCases
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import  androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.newsapplicationjetpack.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MainViewModel @Inject constructor(
    private  val appEntryUseCases: AppEntryUseCases
) :ViewModel() {

    var  splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStarNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen->

            if(shouldStartFromHomeScreen){
                startDestination = Route.NewsNavigation.route
            }else{
                startDestination = Route.AppStarNavigation.route
            }
            delay(300)
            splashCondition= false

        }.launchIn(viewModelScope)
    }




}