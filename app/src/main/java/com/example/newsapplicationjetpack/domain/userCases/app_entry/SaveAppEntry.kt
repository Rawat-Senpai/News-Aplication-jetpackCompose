package com.example.newsapplicationjetpack.domain.userCases.app_entry

import com.example.newsapplicationjetpack.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager:LocalUserManager
) {

    suspend operator  fun invoke(){
        localUserManager.saveAppEntry()
    }


}