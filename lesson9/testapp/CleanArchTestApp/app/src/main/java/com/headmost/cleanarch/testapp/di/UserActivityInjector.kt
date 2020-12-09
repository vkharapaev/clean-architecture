package com.headmost.cleanarch.testapp.di

import com.headmost.cleanarch.testapp.frameworks.view.UserActivity

class UserActivityInjector {

    fun inject(userActivity: UserActivity) {
        val applicationModule =
            (userActivity.application as AppModuleProvider).provideApplicationModule()
        val userActivityModule = UserActivityModule(applicationModule)
        val userPresenter = userActivityModule.getUserPresenter(userActivity)

        userActivity.setPresenter(userPresenter)
    }
}