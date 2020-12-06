package com.headmost.cleanarch.testapp2.usecases

import com.headmost.cleanarch.testapp2.entities.AppState

interface AppStateRepository {
    fun getAppState(): AppState
    fun setAppState(appState: AppState)
}