package com.headmost.cleanarch.testapp.interfaceadapters.presenters

import com.headmost.cleanarch.testapp.entities.User
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractor
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserPresenterImpl(
    private val userView: UserView,
    private val interactor: UserInteractor
) : UserPresenter {

    private var disposable: Disposable? = null

    override fun onStart() {
        userView.showProgress()
        interactor.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(UserObserver())
    }

    override fun onStop() {
        disposable?.dispose()
    }

    override fun onUserAction() {
        userView.showResult()
    }

    private inner class UserObserver : Observer<User?> {
        override fun onSubscribe(d: Disposable?) {
            disposable = d
        }

        override fun onNext(user: User?) {
            userView.hideProgress()
            userView.showUser(user)
        }

        override fun onError(e: Throwable?) {
            userView.hideProgress()
            userView.showError()
        }

        override fun onComplete() {
            // empty
        }
    }
}
