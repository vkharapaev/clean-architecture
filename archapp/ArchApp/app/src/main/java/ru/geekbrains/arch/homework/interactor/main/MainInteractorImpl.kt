package ru.geekbrains.arch.homework.interactor.main

import io.reactivex.Single
import ru.geekbrains.arch.homework.repository.LaunchCountRepository

class MainInteractorImpl(private val launchCountRepository: LaunchCountRepository) :
    MainInteractor {

    override fun shouldShowRateProposal(): Single<Boolean> {
        return launchCountRepository.getLaunchNumber()
            .map { launchNumber -> shouldShowRateProposal(launchNumber) }
    }

    private fun shouldShowRateProposal(launchNumber: Int): Boolean {
        return (launchNumber - 2) % 4 == 0 || launchNumber == 2
    }
}