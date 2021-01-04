package ru.geekbrains.arch.homework.util.logger

interface Logger {
    fun logException(tag: String, message: String, error: Throwable?)
}
