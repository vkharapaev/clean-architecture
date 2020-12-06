package com.headmost.cleanarch.testapp2.usecases

import com.headmost.cleanarch.testapp2.entities.AppState
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AppStateInteractorImplTest {

    @Mock
    private lateinit var appStateRepository: AppStateRepository

    @Test
    fun isShowRateAppDialog() {
        val appState = AppState(1)
        Mockito.`when`(appStateRepository.getAppState()).thenReturn(appState)
        val interactor = AppStateInteractorImpl(appStateRepository)

        interactor.onStart()
        assertEquals(interactor.isShowRateAppDialog(), false)
        interactor.onStart()
        assertEquals(interactor.isShowRateAppDialog(), true)

        for (j in 1..5) {
            for (i in 1..3) {
                interactor.onStart()
                assertEquals(interactor.isShowRateAppDialog(), false)
            }
            interactor.onStart()
            assertEquals(interactor.isShowRateAppDialog(), true)
        }
    }
}