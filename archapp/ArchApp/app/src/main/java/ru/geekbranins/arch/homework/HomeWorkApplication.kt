package ru.geekbranins.arch.homework

import android.app.Application
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import ru.geekbranins.arch.homework.data.launch.LaunchCountRepositoryImpl
import ru.geekbranins.arch.homework.data.launch.PreferenceHelper
import ru.geekbranins.arch.homework.interactor.appstart.AppStartInteractorImpl
import ru.geekbranins.arch.homework.util.LoggerImpl

class HomeWorkApplication : Application() {

    companion object {
        private const val TAG = "HomeWorkApplication"
    }

    override fun onCreate() {
        super.onCreate()

        processAppStart()
    }

    private fun processAppStart() {
        val preferenceHelper = PreferenceHelper(this)
        val launchCountRepository = LaunchCountRepositoryImpl(preferenceHelper)
        val appStartInteractor = AppStartInteractorImpl(launchCountRepository)
        val logger = LoggerImpl()
        appStartInteractor.countAppStart().subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable?) {
            }

            override fun onComplete() {
            }

            override fun onError(e: Throwable?) {
                logger.logException(TAG, "Could not count app start", e)
            }
        })
    }
}