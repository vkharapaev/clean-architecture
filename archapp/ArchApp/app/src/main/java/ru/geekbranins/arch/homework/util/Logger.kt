package ru.geekbranins.arch.homework.util

import android.util.Log

interface Logger {
    fun logException(tag: String, message: String, error: Throwable?)
}
