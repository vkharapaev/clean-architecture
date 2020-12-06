package com.headmost.cleanarch.testapp2.adapters

import com.headmost.cleanarch.testapp2.entities.AppState
import com.headmost.cleanarch.testapp2.usecases.AppStateRepository

class AppStateRepositoryImpl (val appStateDataSource: AppStateDataSource) : AppStateRepository {
    override fun getAppState(): AppState {
        return appStateDataSource.getAppState()
    }

    override fun setAppState(appState: AppState) {
        appStateDataSource.setAppState(appState)
    }
}