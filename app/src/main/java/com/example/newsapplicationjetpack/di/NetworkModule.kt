package com.example.newsapplicationjetpack.di

import android.app.Application
import com.example.newsapplicationjetpack.api.NewsApi
import com.example.newsapplicationjetpack.data.manager.LocalUserManagerImpl
import com.example.newsapplicationjetpack.domain.manager.LocalUserManager
import com.example.newsapplicationjetpack.domain.userCases.AppEntryUseCases
import com.example.newsapplicationjetpack.domain.userCases.ReadAppEntry
import com.example.newsapplicationjetpack.domain.userCases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideNews(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )



}