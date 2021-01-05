package ru.geekbrains.arch.homework.repository

import io.reactivex.Single
import ru.geekbrains.arch.homework.domain.Photo

interface PhotosRepository {
    fun getRecent(pageNumber: Int, pageSize: Int): Single<List<Photo>>
    fun searchPhotos(query: String, pageNumber: Int, pageSize: Int): Single<List<Photo>>
}