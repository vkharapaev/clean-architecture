package ru.geekbrains.arch.homework.interactor.search

import io.reactivex.Observable
import ru.geekbrains.arch.homework.domain.Photo
import ru.geekbrains.arch.homework.repository.PhotosRepository
import javax.inject.Inject

class SearchInteractorImpl @Inject constructor(private val photosRepository: PhotosRepository) :
    SearchInteractor {

    override fun getPhotos(query: String): Observable<List<Photo>> {
        return if (query.isEmpty()) {
            photosRepository.getRecent(0, 100).toObservable()
        } else {
            photosRepository.searchPhotos(query, 0, 100).toObservable()
        }
    }
}
