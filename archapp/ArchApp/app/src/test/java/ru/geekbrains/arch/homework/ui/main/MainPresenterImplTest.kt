package ru.geekbrains.arch.homework.ui.main

import io.reactivex.Single
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner
import ru.geekbrains.arch.homework.interactor.main.MainInteractor
import ru.geekbrains.arch.homework.util.Logger

@RunWith(MockitoJUnitRunner::class)
class MainPresenterImplTest {

    private lateinit var mainPresenter: MainPresenter

    @Mock
    private lateinit var mainIterator: MainInteractor

    @Mock
    private lateinit var view : MainPresenter.View

    @Mock
    private lateinit var logger: Logger

    @Before
    fun setUp() {
        mainPresenter = MainPresenterImpl(view, mainIterator, logger)
    }

    @Test
    fun shouldShowProposalOnStartIfInteractorSaysYes () {
        `when`(mainIterator.shouldShowRateProposal()).thenReturn(Single.just(true))
        mainPresenter.onStart()
        verify(view).showRateProposal()
        verifyNoMoreInteractions(view)
    }

    @Test
    fun shouldNotShowProposalOnStartIfInteractorSaysNo() {
        `when`(mainIterator.shouldShowRateProposal()).thenReturn(Single.just(false))
        mainPresenter.onStart()
        verifyNoMoreInteractions(view)
    }

    @Test
    fun shouldShowNothingOnStartIfInteractorError() {
        `when`(mainIterator.shouldShowRateProposal()).thenReturn(Single.error(Throwable()))
        mainPresenter.onStart()
        verifyNoMoreInteractions(view)
    }

}
