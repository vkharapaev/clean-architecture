package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractor
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractorImpl

class UserInteractorProvider(private val userRepositoryProvider: UserRepositoryProvider) {

    private lateinit var userInteractor: UserInteractor

    fun provideUserInteractor(): UserInteractor {
        if (!this::userInteractor.isInitialized) {
            userInteractor = UserInteractorImpl(userRepositoryProvider.provideUserRepository())
        }
        return userInteractor
    }
}