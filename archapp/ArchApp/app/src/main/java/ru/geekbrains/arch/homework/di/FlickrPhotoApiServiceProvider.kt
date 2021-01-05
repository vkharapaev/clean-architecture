package ru.geekbrains.arch.homework.di

import ru.geekbrains.arch.homework.network.flickr.FlickrApi
import ru.geekbrains.arch.homework.network.flickr.FlickrPhotoApiService
import javax.inject.Inject
import javax.inject.Provider

class FlickrPhotoApiServiceProvider @Inject constructor(private val flickApi: FlickrApi) :
    Provider<FlickrPhotoApiService> {

    override fun get(): FlickrPhotoApiService {
        return flickApi.getService()
    }

}
