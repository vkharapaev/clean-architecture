package com.headmost.cleanarch.testapp2.usecases

import com.headmost.cleanarch.testapp2.entities.AppState

class AppStateInteractorImpl(
    val appStateRepository: AppStateRepository
) : AppStateInteractor {

    private var showRateAppDialog: Boolean = false

    override fun getAppState(): AppState {
        return appStateRepository.getAppState()
    }

    override fun onStart() {
        val appState = appStateRepository.getAppState()
        showRateAppDialog = appState.runCount == 2 || (appState.runCount - 2) % 4 == 0
        appState.runCount += 1
        appStateRepository.setAppState(appState)
    }

    override fun isShowRateAppDialog(): Boolean {
        return showRateAppDialog;
    }
}