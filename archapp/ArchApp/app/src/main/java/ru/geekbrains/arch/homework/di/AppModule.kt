package ru.geekbrains.arch.homework.di

import android.content.Context
import ru.geekbrains.arch.homework.data.launch.LaunchCountRepositoryImpl
import ru.geekbrains.arch.homework.data.photo.PhotoDataSource
import ru.geekbrains.arch.homework.data.photo.PhotoDataSourceImpl
import ru.geekbrains.arch.homework.data.photo.PhotosRepositoryImpl
import ru.geekbrains.arch.homework.data.preference.PreferenceHelper
import ru.geekbrains.arch.homework.network.ApiKeyProvider
import ru.geekbrains.arch.homework.network.HostProvider
import ru.geekbrains.arch.homework.network.flickr.FlickrApiKeyProvider
import ru.geekbrains.arch.homework.network.flickr.FlickrHostProvider
import ru.geekbrains.arch.homework.network.flickr.FlickrPhotoApiService
import ru.geekbrains.arch.homework.repository.LaunchCountRepository
import ru.geekbrains.arch.homework.repository.PhotosRepository
import ru.geekbrains.arch.homework.util.logger.Logger
import ru.geekbrains.arch.homework.util.logger.LoggerImpl
import ru.geekbrains.arch.homework.util.resources.ResourceManager
import ru.geekbrains.arch.homework.util.resources.ResourceManagerImpl
import toothpick.config.Module

class AppModule(context: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(context.applicationContext)
        bind(PreferenceHelper::class.java).to(PreferenceHelper::class.java).singleton()
        bind(LaunchCountRepository::class.java).to(LaunchCountRepositoryImpl::class.java)
            .singleton()
        bind(Logger::class.java).to(LoggerImpl::class.java).singleton()

        bind(ResourceManager::class.java).to(ResourceManagerImpl::class.java).singleton()
        bind(ApiKeyProvider::class.java).to(FlickrApiKeyProvider::class.java).singleton()
        bind(HostProvider::class.java).to(FlickrHostProvider::class.java).singleton()

        bind(FlickrPhotoApiService::class.java).toProvider(FlickrPhotoApiServiceProvider::class.java)
            .singleton()
        bind(PhotoDataSource::class.java).to(PhotoDataSourceImpl::class.java).singleton()
        bind(PhotosRepository::class.java).to(PhotosRepositoryImpl::class.java).singleton()
    }
}
