package ru.geekbrains.arch.homework.interactor.appstart

import io.reactivex.Completable
import ru.geekbrains.arch.homework.repository.LaunchCountRepository
import javax.inject.Inject

class AppStartInteractorImpl @Inject constructor(private val launchCountRepository: LaunchCountRepository) :
    AppStartInteractor {

    override fun countAppStart(): Completable {
        return launchCountRepository.getLaunchNumber()
            .flatMapCompletable { launchNumber ->
                launchCountRepository.setLaunchNumber(launchNumber + 1)
            }
    }

}
