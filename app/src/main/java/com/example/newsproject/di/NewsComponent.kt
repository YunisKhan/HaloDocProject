package com.example.newsproject.di

import android.app.Activity
import com.example.newsproject.repository.NewsRepository
import com.example.newsproject.viewmodel.NewsViewModelFactory
import com.example.newsproject.webservice.NewsWebservice
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(dependencies = [NetworkComponent::class], modules = [NewsModule::class])
interface NewsComponent {

    fun inject(activity: Activity)

    fun viewModelFactory(): NewsViewModelFactory
}

@Module
class NewsModule {

    @Provides
    fun repository(webservice: NewsWebservice): NewsRepository = NewsRepository(webservice)

    @Provides
    fun viewModelFactory(repository: NewsRepository): NewsViewModelFactory = NewsViewModelFactory(repository)
}