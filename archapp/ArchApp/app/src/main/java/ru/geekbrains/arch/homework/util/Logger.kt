package ru.geekbrains.arch.homework.util

interface Logger {
    fun logException(tag: String, message: String, error: Throwable?)
}
