package ru.geekbrains.arch.homework.network.flickr

import ru.geekbrains.arch.homework.R
import ru.geekbrains.arch.homework.network.ApiKeyProvider
import ru.geekbrains.arch.homework.util.resources.ResourceManager
import javax.inject.Inject

class FlickrApiKeyProvider @Inject constructor(private val resourceManager: ResourceManager) : ApiKeyProvider {
    override fun getApiKey(): String {
        return resourceManager.getString(R.string.flickr_api_key)
    }
}
