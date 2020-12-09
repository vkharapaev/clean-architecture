package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.interfaceadapters.data.UserRepositoryImpl
import com.headmost.cleanarch.testapp.usecases.repositories.UserRepository

class UserRepositoryProvider(private val userDataSourceProvider: UserDataSourceProvider) {

    private lateinit var userRepository: UserRepository

    fun provideUserRepository(): UserRepository {
        if (!this::userRepository.isInitialized) {
            userRepository = UserRepositoryImpl(userDataSourceProvider.provideUserDataSource())
        }
        return userRepository
    }
}