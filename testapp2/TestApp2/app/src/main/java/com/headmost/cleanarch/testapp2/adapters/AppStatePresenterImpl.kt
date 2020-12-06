package com.headmost.cleanarch.testapp2.adapters

import com.headmost.cleanarch.testapp2.entities.AppState
import com.headmost.cleanarch.testapp2.usecases.AppStateInteractor

class AppStatePresenterImpl(val appStateInteractor: AppStateInteractor, val view: AppStateView) :
    AppStatePresenter {

    override fun getAppState(): AppState {
        return appStateInteractor.getAppState()
    }

    override fun onStart() {
        appStateInteractor.onStart()
        if (appStateInteractor.isShowRateAppDialog()) {
            view.showRateAppDialog()
        }
    }

    override fun onStop() {
    }

}