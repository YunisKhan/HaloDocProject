package com.example.newsproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsproject.model.News
import com.example.newsproject.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    fun getNews(type: String): LiveData<List<News>> {

        val liveData: MutableLiveData<List<News>> = MutableLiveData()

        viewModelScope.launch {

            val result = repository.getNews(type)

            liveData.value = result
        }

        return liveData
    }
}