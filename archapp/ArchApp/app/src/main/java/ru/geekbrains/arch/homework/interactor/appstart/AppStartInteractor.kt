package ru.geekbrains.arch.homework.interactor.appstart

import io.reactivex.Completable

interface AppStartInteractor {
    fun countAppStart(): Completable
}