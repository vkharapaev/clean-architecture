package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.interfaceadapters.data.UserRepositoryImpl
import com.headmost.cleanarch.testapp.usecases.repositories.UserRepository

class UserRepositoryProvider(private val userDataSourceProvider: UserDataSourceProvider) {

    private val userRepository by lazy {
        UserRepositoryImpl(userDataSourceProvider.provideUserDataSource())
    }

    fun provideUserRepository(): UserRepository {
        return userRepository
    }
}