package ru.geekbranins.arch.homework.interactor.main

import io.reactivex.Single

interface MainInteractor {
    fun shouldShowRateProposal(): Single<Boolean>
}