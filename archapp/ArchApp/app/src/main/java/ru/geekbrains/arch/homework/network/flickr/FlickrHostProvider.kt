package ru.geekbrains.arch.homework.network.flickr

import ru.geekbrains.arch.homework.R
import ru.geekbrains.arch.homework.network.HostProvider
import ru.geekbrains.arch.homework.util.resources.ResourceManager

class FlickrHostProvider(private val resourceManager: ResourceManager) : HostProvider {
    override fun getHostUrl() = resourceManager.getString(R.string.flickr_host)
}