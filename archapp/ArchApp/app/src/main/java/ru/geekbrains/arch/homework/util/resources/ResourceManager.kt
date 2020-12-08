package ru.geekbrains.arch.homework.util.resources

import androidx.annotation.StringRes

interface ResourceManager {
    fun getString(@StringRes id: Int): String
}