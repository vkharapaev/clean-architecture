package ru.geekbrains.arch.homework.util.logger

import android.util.Log

class LoggerImpl : Logger {
    override fun logException(tag: String, message: String, error: Throwable?) {
        Log.e(tag, message, error)
    }
}