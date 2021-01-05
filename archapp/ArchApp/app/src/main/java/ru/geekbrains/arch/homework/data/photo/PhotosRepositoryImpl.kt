package ru.geekbrains.arch.homework.data.photo

import io.reactivex.Single
import ru.geekbrains.arch.homework.domain.Photo
import ru.geekbrains.arch.homework.repository.PhotosRepository
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(private val photoDataSource: PhotoDataSource) : PhotosRepository {
    override fun getRecent(pageNumber: Int, pageSize: Int): Single<List<Photo>> {
        return photoDataSource.getRecent(pageNumber, pageSize)
    }

    override fun searchPhotos(query: String, pageNumber: Int, pageSize: Int): Single<List<Photo>> {
        return photoDataSource.search(query, pageNumber, pageSize)
    }
}
