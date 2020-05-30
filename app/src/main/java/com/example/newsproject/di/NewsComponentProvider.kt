package com.example.newsproject.di

object NewsComponentProvider {

    var networkComponent: NetworkComponent? = null
    var newsComponent: NewsComponent?       = null

    fun getComponent(): NewsComponent? {

        if (networkComponent == null) {

            networkComponent = DaggerNetworkComponent.create()
        }

        if (newsComponent == null) {

            newsComponent = DaggerNewsComponent.builder()
                .networkComponent(networkComponent)
                .build()
        }

        return newsComponent
    }
}