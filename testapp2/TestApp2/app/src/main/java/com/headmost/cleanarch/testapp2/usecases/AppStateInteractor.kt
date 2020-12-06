package com.headmost.cleanarch.testapp2.usecases

import com.headmost.cleanarch.testapp2.entities.AppState

interface AppStateInteractor {
    fun getAppState(): AppState
    fun onStart()
    fun isShowRateAppDialog(): Boolean
}