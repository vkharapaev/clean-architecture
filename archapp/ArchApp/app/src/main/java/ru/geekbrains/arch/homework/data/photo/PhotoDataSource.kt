package ru.geekbrains.arch.homework.data.photo

import io.reactivex.Single
import ru.geekbrains.arch.homework.domain.Photo

interface PhotoDataSource {
    fun getRecent(pageNumber: Int, perPage: Int): Single<List<Photo>>
}