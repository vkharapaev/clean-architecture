package ru.geekbrains.arch.homework.interactor.search

import io.reactivex.Observable
import ru.geekbrains.arch.homework.domain.Photo

interface SearchInteractor {
    fun getPhotos(query: String): Observable<List<Photo>>
}
