package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.frameworks.network.UserRemoteDataSource
import com.headmost.cleanarch.testapp.interfaceadapters.data.UserDataSource

class UserDataSourceProvider(private val jsonPlaceHolderApliProvider: JsonPlaceHolderApiProvider) {

    private lateinit var userDataSource: UserDataSource

    fun provideUserDataSource(): UserDataSource {
        if (!this::userDataSource.isInitialized) {
            userDataSource = UserRemoteDataSource(jsonPlaceHolderApliProvider.provideJsonPlaceHolderApi())
        }
        return userDataSource
    }
}