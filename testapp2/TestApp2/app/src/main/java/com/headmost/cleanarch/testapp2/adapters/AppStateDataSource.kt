package com.headmost.cleanarch.testapp2.adapters

import com.headmost.cleanarch.testapp2.entities.AppState

interface AppStateDataSource {
    fun getAppState(): AppState
    fun setAppState(state: AppState)
}