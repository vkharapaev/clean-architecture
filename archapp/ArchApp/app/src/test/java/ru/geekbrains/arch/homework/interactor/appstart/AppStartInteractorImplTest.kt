package ru.geekbrains.arch.homework.interactor.appstart

import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner
import ru.geekbrains.arch.homework.repository.LaunchCountRepository

@RunWith(MockitoJUnitRunner::class)
class AppStartInteractorImplTest {

    private lateinit var appStartInteractor: AppStartInteractor

    @Mock
    private lateinit var launchCountRepository: LaunchCountRepository

    @Before
    fun setUp() {
        appStartInteractor = AppStartInteractorImpl(launchCountRepository)
    }

    @Test
    fun shouldSetFirstLaunchNumberWhenWasZero() {
        testCountAppStart(0, 1)
    }

    @Test
    fun shouldSetSecondLaunchNumberWhenWasFirst() {
        testCountAppStart(1, 2)
    }

    @Test
    fun shouldSetThirdLaunchNumberWhenWasSecond() {
        testCountAppStart(2, 3)
    }

    private fun testCountAppStart(storedLaunchNumber: Int, expectedLaunchNumber: Int) {
        `when`(launchCountRepository.getLaunchNumber()).thenReturn(Single.just(storedLaunchNumber))

        val testObserver = TestObserver<Void>()

        appStartInteractor.countAppStart().subscribe(testObserver)

        verify(launchCountRepository).setLaunchNumber(expectedLaunchNumber)
    }

}