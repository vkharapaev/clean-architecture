package ru.geekbranins.arch.homework.ui.main

import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.geekbranins.arch.homework.interactor.main.MainInteractor
import ru.geekbranins.arch.homework.util.Logger

class MainPresenterImpl(
    private val view: MainPresenter.View,
    private val mainInteractor: MainInteractor,
    private val logger: Logger
) : MainPresenter {

    private val compositeDisposable: CompositeDisposable

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

    init {
        compositeDisposable = CompositeDisposable()
    }

}