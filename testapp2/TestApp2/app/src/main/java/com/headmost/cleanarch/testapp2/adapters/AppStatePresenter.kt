package com.headmost.cleanarch.testapp2.adapters

import com.headmost.cleanarch.testapp2.entities.AppState

interface AppStatePresenter {
    fun getAppState(): AppState
    fun onStart()
    fun onStop()
}