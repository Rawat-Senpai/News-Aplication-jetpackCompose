package com.example.newsapplicationjetpack.di

import android.app.Application
import com.example.newsapplicationjetpack.data.remote.NewsApi
import com.example.newsapplicationjetpack.data.manager.LocalUserManagerImpl
import com.example.newsapplicationjetpack.data.repository.NewsRepositoryImpl
import com.example.newsapplicationjetpack.domain.manager.LocalUserManager
import com.example.newsapplicationjetpack.domain.repository.NewsRepository
import com.example.newsapplicationjetpack.domain.userCases.app_entry.AppEntryUseCases
import com.example.newsapplicationjetpack.domain.userCases.app_entry.ReadAppEntry
import com.example.newsapplicationjetpack.domain.userCases.app_entry.SaveAppEntry
import com.example.newsapplicationjetpack.domain.userCases.news.GetNews
import com.example.newsapplicationjetpack.domain.userCases.news.NewsUseCases
import com.example.newsapplicationjetpack.utils.Constants
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

//    @Singleton
//    @Provides
//    fun provideRetrofit(): Retrofit {
//        return Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

//    @Singleton
//    @Provides
//    fun provideNews(retrofit: Retrofit): NewsApi {
//        return retrofit.create(NewsApi::class.java)
//    }

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


    @Provides
    @Singleton
    fun provideNewsApi():NewsApi{
        return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi:NewsApi): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository):NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }



}