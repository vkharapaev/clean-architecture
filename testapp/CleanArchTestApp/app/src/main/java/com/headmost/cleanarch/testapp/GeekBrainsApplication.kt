package com.headmost.cleanarch.testapp

import android.app.Application
import com.headmost.cleanarch.testapp.frameworks.network.JsonPlaceHolderApi
import com.headmost.cleanarch.testapp.frameworks.network.UserRemoteDataSource
import com.headmost.cleanarch.testapp.interfaceadapters.data.UserRepositoryImpl
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractor
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractorImpl

class GeekBrainsApplication : Application(), LocatorHost {

    private val locator  = ServiceLocator()

    override fun onCreate() {
        super.onCreate()

        registerUserInteractor()
    }

    private fun registerUserInteractor() {
        val jsonPlaceHolderApi = JsonPlaceHolderApi()
        val dataSource = UserRemoteDataSource(jsonPlaceHolderApi)
        val userRepository = UserRepositoryImpl(dataSource)
        val userInteractor = UserInteractorImpl(userRepository)

        locator.register(UserInteractor::class.java, userInteractor)
    }

    override fun getLocator(): ServiceLocator {
        return locator
    }
}