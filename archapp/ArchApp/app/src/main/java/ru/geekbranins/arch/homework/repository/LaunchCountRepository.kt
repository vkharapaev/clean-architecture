package ru.geekbranins.arch.homework.repository

import io.reactivex.Single
import io.reactivex.Completable

interface LaunchCountRepository {
    fun setLaunchNumber(launchNumber: Int): Completable
    fun getLaunchNumber(): Single<Int>
}