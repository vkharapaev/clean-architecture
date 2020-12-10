package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractor
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractorImpl

class UserInteractorProvider(private val userRepositoryProvider: UserRepositoryProvider) {

    private val userInteractor by lazy {
        UserInteractorImpl(userRepositoryProvider.provideUserRepository())
    }

    fun provideUserInteractor(): UserInteractor {
        return userInteractor
    }
}