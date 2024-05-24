package com.example.newsapplicationjetpack.domain.userCases.app_entry

import com.example.newsapplicationjetpack.domain.manager.LocalUserManager
 import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

     operator fun invoke(): Flow<Boolean>{
        return localUserManager.readAppEntry()
    }


}