package com.example.newsproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsproject.repository.NewsRepository
import java.lang.IllegalArgumentException

class NewsViewModelFactory(val repository: NewsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == NewsViewModel::class.java) {

            return NewsViewModel(repository) as T
        } else {

            throw IllegalArgumentException("view model not available")
        }
    }
}