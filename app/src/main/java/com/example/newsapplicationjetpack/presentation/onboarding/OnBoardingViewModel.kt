package com.example.newsapplicationjetpack.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplicationjetpack.domain.userCases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases:AppEntryUseCases
):ViewModel() {

    fun onEvent(events: OnBoardingEvents){
        when(events){
            is OnBoardingEvents.SaveAppEntry ->{
                saveAppEntry()
            }

        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }

    }

}