package ru.geekbrains.arch.homework.util.logger

import android.util.Log
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {
    override fun logException(tag: String, message: String, error: Throwable?) {
        Log.e(tag, message, error)
    }
}
