package com.headmost.cleanarch.testapp.di

class ApplicationModule {

    private lateinit var jsonPlaceHolderApiProvider: JsonPlaceHolderApiProvider
    private lateinit var userDataSourceProvider: UserDataSourceProvider
    private lateinit var userRepositoryProvider: UserRepositoryProvider

    private fun getJsonPlaceHolderApliProvider(): JsonPlaceHolderApiProvider {
        if (!this::jsonPlaceHolderApiProvider.isInitialized) {
            jsonPlaceHolderApiProvider = JsonPlaceHolderApiProvider()
        }
        return jsonPlaceHolderApiProvider
    }

    private fun getUserDataSourceProvider(): UserDataSourceProvider {
        if (!this::jsonPlaceHolderApiProvider.isInitialized) {
            userDataSourceProvider = UserDataSourceProvider(getJsonPlaceHolderApliProvider())
        }
        return userDataSourceProvider
    }

    fun getUserRepositoryProvider(): UserRepositoryProvider {
        if (!this::userRepositoryProvider.isInitialized) {
            userRepositoryProvider = UserRepositoryProvider(getUserDataSourceProvider())
        }
        return userRepositoryProvider
    }

}