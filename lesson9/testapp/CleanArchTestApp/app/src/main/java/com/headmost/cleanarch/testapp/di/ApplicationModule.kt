package com.headmost.cleanarch.testapp.di

class ApplicationModule {
    private val jsonPlaceHolderApiProvider by lazy {
        JsonPlaceHolderApiProvider()
    }

    private val userDataSourceProvider by lazy {
        UserDataSourceProvider(jsonPlaceHolderApiProvider)
    }

    private val userRepositoryProvider by lazy {
        UserRepositoryProvider(userDataSourceProvider)
    }

    fun provideUserRepositoryProvider(): UserRepositoryProvider {
        return userRepositoryProvider
    }
}