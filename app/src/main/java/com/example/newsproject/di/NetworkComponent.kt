package com.example.newsproject.di

import com.example.newsproject.webservice.NewsWebservice
import com.squareup.moshi.Moshi
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun webService(): NewsWebservice
}

@Module
class NetworkModule {

    @Provides
    fun baseUrl(): String = "https://hn.algolia.com/api/v1/"

    @Provides
    fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(NewsIntercepter())
        .build()

    @Provides
    fun moshi(): Moshi = Moshi.Builder().build()

    @Provides
    fun retrofit(baserurl: String, moshi: Moshi, okHttpClient: OkHttpClient) : Retrofit =
        Retrofit.Builder()
            .baseUrl(baserurl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    fun webService(retrofit: Retrofit) = retrofit.create(NewsWebservice::class.java)
}