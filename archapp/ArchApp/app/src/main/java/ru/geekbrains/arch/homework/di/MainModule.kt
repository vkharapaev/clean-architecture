package ru.geekbrains.arch.homework.di

import ru.geekbrains.arch.homework.interactor.main.MainInteractor
import ru.geekbrains.arch.homework.interactor.main.MainInteractorImpl
import ru.geekbrains.arch.homework.ui.main.MainPresenter
import ru.geekbrains.arch.homework.ui.main.MainPresenterImpl
import toothpick.config.Module

class MainModule(view: MainPresenter.View): Module() {
    init {
        bind(MainInteractor::class.java).to(MainInteractorImpl::class.java).singleton()
        bind(MainPresenter.View::class.java).toInstance(view)
        bind(MainPresenter::class.java).to(MainPresenterImpl::class.java).singleton()
    }
}
