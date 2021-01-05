package ru.geekbrains.arch.homework

import android.app.Application
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import ru.geekbrains.arch.homework.data.launch.LaunchCountRepositoryImpl
import ru.geekbrains.arch.homework.data.preference.PreferenceHelper
import ru.geekbrains.arch.homework.di.AppModule
import ru.geekbrains.arch.homework.di.AppStartModule
import ru.geekbrains.arch.homework.di.Scopes
import ru.geekbrains.arch.homework.interactor.appstart.AppStartInteractor
import ru.geekbrains.arch.homework.interactor.appstart.AppStartInteractorImpl
import ru.geekbrains.arch.homework.util.logger.Logger
import ru.geekbrains.arch.homework.util.logger.LoggerImpl
import toothpick.Toothpick

class HomeWorkApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initDi()
        processAppStart()
    }

    private fun initDi() {
        val appScope = Toothpick.openScope(Scopes.APP)
        appScope.installModules(AppModule(this))
    }

    private fun processAppStart() {
        val scope = Toothpick.openScopes(Scopes.APP, Scopes.APP_START)
        scope.installModules(AppStartModule())

        val appStartInteractor = scope.getInstance(AppStartInteractor::class.java)

        appStartInteractor.countAppStart().subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onComplete() {
                Toothpick.closeScope(Scopes.APP_START)
            }

            override fun onError(e: Throwable) {
                val logger = scope.getInstance(Logger::class.java)
                logger.logException(TAG, "Could not count app start", e)
                Toothpick.closeScope(Scopes.APP_START)
            }
        })
    }

    companion object {
        private const val TAG = "HomeWorkApplication"
    }
}
