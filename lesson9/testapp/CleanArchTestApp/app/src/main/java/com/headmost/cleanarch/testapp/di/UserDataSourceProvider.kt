package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.frameworks.network.UserRemoteDataSource
import com.headmost.cleanarch.testapp.interfaceadapters.data.UserDataSource

class UserDataSourceProvider(private val jsonPlaceHolderApiProvider: JsonPlaceHolderApiProvider) {

    private val userDataSource by lazy {
        UserRemoteDataSource(jsonPlaceHolderApiProvider.provideJsonPlaceHolderApi())
    }

    fun provideUserDataSource(): UserRemoteDataSource {
        return userDataSource
    }

}