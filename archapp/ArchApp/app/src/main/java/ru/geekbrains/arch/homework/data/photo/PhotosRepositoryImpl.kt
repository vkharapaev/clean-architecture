package ru.geekbrains.arch.homework.data.photo

import io.reactivex.Single
import ru.geekbrains.arch.homework.domain.Photo
import ru.geekbrains.arch.homework.repository.PhotosRepository

class PhotosRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotosRepository {
    override fun getRecent(pageNumber: Int, pageSize: Int): Single<List<Photo>> {
        return photoDataSource.getRecent(pageNumber, pageSize)
    }
}