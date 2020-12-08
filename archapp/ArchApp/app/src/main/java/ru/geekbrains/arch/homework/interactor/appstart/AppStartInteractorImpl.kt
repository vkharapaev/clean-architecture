package ru.geekbrains.arch.homework.interactor.appstart

import io.reactivex.Completable
import ru.geekbrains.arch.homework.repository.LaunchCountRepository

class AppStartInteractorImpl(private val launchCountRepository: LaunchCountRepository) :
    AppStartInteractor {

    override fun countAppStart(): Completable {
        return launchCountRepository.getLaunchNumber()
            .flatMapCompletable { launchNumber ->
                launchCountRepository.setLaunchNumber(launchNumber + 1)
            }
    }

}