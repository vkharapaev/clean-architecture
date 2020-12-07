package ru.geekbranins.arch.homework.interactor.appstart

import io.reactivex.Completable
import ru.geekbranins.arch.homework.repository.LaunchCountRepository

class AppStartInteractorImpl(private val launchCountRepository: LaunchCountRepository) :
    AppStartInteractor {

    override fun countAppStart(): Completable {
        return launchCountRepository.getLaunchNumber()
            .flatMapCompletable { launchNumber ->
                launchCountRepository.setLaunchNumber(launchNumber + 1)
            }
    }

}