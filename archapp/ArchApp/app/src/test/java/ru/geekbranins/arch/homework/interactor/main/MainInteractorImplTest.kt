package ru.geekbranins.arch.homework.interactor.main

import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner
import ru.geekbranins.arch.homework.repository.LaunchCountRepository

@RunWith(MockitoJUnitRunner::class)
class MainInteractorImplTest {

    private lateinit var mainInteractor: MainInteractor

    @Mock
    private lateinit var launchCountRepository: LaunchCountRepository

    @Before
    fun setUp() {
        mainInteractor = MainInteractorImpl(launchCountRepository)
    }

    @Test
    fun showNotShowProposalOnZeroLaunch() {
        testShowRateProposal(0, false)
    }

    @Test
    fun showNotShowProposalOnFirstLaunch() {
        testShowRateProposal(1, false)
    }

    @Test
    fun showShowProposalOnSecondLaunch() {
        testShowRateProposal(2, true)
    }

    @Test
    fun showNotShowProposalOnThirdLaunch() {
        testShowRateProposal(3, false)
    }

    @Test
    fun showNotShowProposalOnForthLaunch() {
        testShowRateProposal(4, false)
    }

    @Test
    fun showNotShowProposalOnFifthLaunch() {
        testShowRateProposal(5, false)
    }

    @Test
    fun showShowProposalOnSixthLaunch() {
        testShowRateProposal(6, true)
    }

    private fun testShowRateProposal(launchNumber: Int, isExpectedToShowProposal: Boolean) {
        `when`(launchCountRepository.getLaunchNumber()).thenReturn(Single.just(launchNumber))
        val subscriber = TestObserver<Boolean>()
        mainInteractor.shouldShowRateProposal().subscribe(subscriber)
        subscriber.assertValue(isExpectedToShowProposal)
    }

}