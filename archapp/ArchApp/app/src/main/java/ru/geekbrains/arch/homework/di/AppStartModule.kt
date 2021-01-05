package ru.geekbrains.arch.homework.di

import ru.geekbrains.arch.homework.interactor.appstart.AppStartInteractor
import ru.geekbrains.arch.homework.interactor.appstart.AppStartInteractorImpl
import toothpick.config.Module

class AppStartModule : Module() {
    init {
        bind(AppStartInteractor::class.java).to(AppStartInteractorImpl::class.java).singleton()
    }
}
