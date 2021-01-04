package com.headmost.cleanarch.testapp

import android.app.Application
import com.headmost.cleanarch.testapp.di.AppModuleProvider
import com.headmost.cleanarch.testapp.di.ApplicationModule
import com.headmost.cleanarch.testapp.frameworks.network.JsonPlaceHolderApi
import com.headmost.cleanarch.testapp.frameworks.network.UserRemoteDataSource
import com.headmost.cleanarch.testapp.interfaceadapters.data.UserRepositoryImpl
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractor
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractorImpl

class ArchDemoApplication : Application(), AppModuleProvider {

    private lateinit var applicationModule: ApplicationModule

    override fun onCreate() {
        super.onCreate()

        applicationModule = ApplicationModule()
    }

    override fun provideApplicationModule(): ApplicationModule {
        return applicationModule
    }
}