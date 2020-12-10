package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.frameworks.view.UserActivity
import com.headmost.cleanarch.testapp.interfaceadapters.presenters.UserPresenter
import com.headmost.cleanarch.testapp.interfaceadapters.presenters.UserPresenterImpl

class UserActivityPresenterProvider(private val userInteractorProvider: UserInteractorProvider) {

    private lateinit var userPresenter: UserPresenter

    fun provideUserPresenter(userActivity: UserActivity): UserPresenter {
        if (!this::userPresenter.isInitialized) {
            userPresenter = UserPresenterImpl(userActivity, userInteractorProvider.provideUserInteractor())
        }
        return userPresenter
    }
}