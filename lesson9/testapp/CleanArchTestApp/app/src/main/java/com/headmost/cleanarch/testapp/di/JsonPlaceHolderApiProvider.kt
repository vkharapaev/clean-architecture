package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.frameworks.network.JsonPlaceHolderApi

class JsonPlaceHolderApiProvider {

    private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi

    fun provideJsonPlaceHolderApi(): JsonPlaceHolderApi {
        if (!this::jsonPlaceHolderApi.isInitialized) {
            jsonPlaceHolderApi = JsonPlaceHolderApi()
        }
        return jsonPlaceHolderApi
    }
}