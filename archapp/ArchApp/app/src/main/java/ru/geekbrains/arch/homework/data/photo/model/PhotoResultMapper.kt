package ru.geekbrains.arch.homework.data.photo.model

import ru.geekbrains.arch.homework.domain.Photo

class PhotoResultMapper {
    fun map(apiResult: ApiResult): List<Photo> {
        val photoPage = apiResult.photos
        val photos = ArrayList<Photo>(photoPage.photos.size)
        for((url) in photoPage.photos) {
            photos.add(Photo(url))
        }
        return photos
    }
}