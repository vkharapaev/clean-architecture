package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.frameworks.view.UserActivity
import com.headmost.cleanarch.testapp.interfaceadapters.presenters.UserPresenter

class UserActivityModule (private val applicationModule: ApplicationModule) {

    private fun getUserInteractorProvider(): UserInteractorProvider {
        return UserInteractorProvider(applicationModule.getUserRepositoryProvider())
    }

    private fun getUserActivityPresenterProvider(): UserActivityPresenterProvider {
        return UserActivityPresenterProvider(getUserInteractorProvider())
    }

    fun getUserPresenter(userActivity: UserActivity): UserPresenter {
        return getUserActivityPresenterProvider().providePresenter(userActivity)
    }

}