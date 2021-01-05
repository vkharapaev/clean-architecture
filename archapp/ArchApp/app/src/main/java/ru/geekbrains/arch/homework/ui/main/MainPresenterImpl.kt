package ru.geekbrains.arch.homework.ui.main

import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.geekbrains.arch.homework.interactor.main.MainInteractor
import ru.geekbrains.arch.homework.util.logger.Logger
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainPresenter.View,
    private val mainInteractor: MainInteractor,
    private val logger: Logger
) : MainPresenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onStart() {
        mainInteractor.shouldShowRateProposal().subscribe(object : SingleObserver<Boolean> {
            override fun onSubscribe(disposable: Disposable) {
                compositeDisposable.add(disposable)
            }

            override fun onSuccess(shouldShowRateProposal: Boolean) {
                if (shouldShowRateProposal) {
                    view.showRateProposal()
                }
            }

            override fun onError(e: Throwable) {
                logger.logException(TAG, "Should show rate error", e)
            }
        })
    }

    override fun onStop() {
        compositeDisposable.dispose()
    }

    override fun onRatePositive() {
    }

    override fun onRateNegative() {
    }

    companion object {
        private const val TAG = "Main"
    }

}