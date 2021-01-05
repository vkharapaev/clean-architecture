package ru.geekbrains.arch.homework.ui.search

import io.reactivex.Observable
import ru.geekbrains.arch.homework.domain.Photo

interface SearchPhotoViewModel {
    fun onSearchQueryUpdated(query: String)
    fun getPhotos(): Observable<List<Photo>>
    fun onStart()
    fun onStop()
}
