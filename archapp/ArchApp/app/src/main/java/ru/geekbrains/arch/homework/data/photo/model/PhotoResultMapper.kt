package ru.geekbrains.arch.homework.data.photo.model

import ru.geekbrains.arch.homework.domain.Photo
import javax.inject.Inject

class PhotoResultMapper @Inject constructor() {
    fun map(apiResult: ApiResult): List<Photo> {
        val photoPage = apiResult.photos
        val photos = ArrayList<Photo>(photoPage.photos.size)
        for (apiPhoto in photoPage.photos) {
            photos.add(Photo(apiPhoto.url))
        }
        return photos
    }
}
