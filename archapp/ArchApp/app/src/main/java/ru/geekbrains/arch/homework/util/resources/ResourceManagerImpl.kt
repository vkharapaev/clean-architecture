package ru.geekbrains.arch.homework.util.resources

import android.content.Context
import androidx.annotation.StringRes

class ResourceManagerImpl(private val context: Context) : ResourceManager {
    override fun getString(@StringRes id: Int) = context.getString(id)
}