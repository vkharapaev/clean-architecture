package ru.geekbrains.arch.homework.data.photo

import io.reactivex.Single
import ru.geekbrains.arch.homework.data.photo.model.PhotoResultMapper
import ru.geekbrains.arch.homework.domain.Photo
import ru.geekbrains.arch.homework.network.flickr.FlickrApiKeyProvider
import ru.geekbrains.arch.homework.network.flickr.FlickrPhotoApiService
import javax.inject.Inject

class PhotoDataSourceImpl @Inject constructor(
    private val service: FlickrPhotoApiService,
    private val apiKeyProvider: FlickrApiKeyProvider,
    private val photoResultMapper: PhotoResultMapper
) : PhotoDataSource {

    override fun getRecent(pageNumber: Int, perPage: Int): Single<List<Photo>> {
        return service.getPhotos(
            FLICKR_PHOTOS_RECENT,
            apiKeyProvider.getApiKey(),
            JSON,
            NO_JSON_CALLBACK,
            perPage,
            pageNumber,
            URL_S,
            null
        ).map { apiResult -> photoResultMapper.map(apiResult) }
    }

    override fun search(query: String, pageNumber: Int, perPage: Int): Single<List<Photo>> {
        return service.getPhotos(
            FLICKR_PHOTOS_SEARCH,
            apiKeyProvider.getApiKey(),
            JSON,
            NO_JSON_CALLBACK,
            perPage,
            pageNumber,
            URL_S,
            query
        ).map { apiResult -> photoResultMapper.map(apiResult) }
    }

    companion object {
        private const val FLICKR_PHOTOS_RECENT = "flickr.photos.getRecent"
        private const val FLICKR_PHOTOS_SEARCH = "flickr.photos.search"
        private const val JSON = "json"
        private const val NO_JSON_CALLBACK = "1"
        private const val URL_S = "url_s"
    }
}
