package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.frameworks.network.JsonPlaceHolderApi

class JsonPlaceHolderApiProvider {

    private val jsonPlaceHolderApi by lazy {
        JsonPlaceHolderApi()
    }

    fun provideJsonPlaceHolderApi(): JsonPlaceHolderApi {
        return jsonPlaceHolderApi
    }
}