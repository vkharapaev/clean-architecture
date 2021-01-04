package com.headmost.cleanarch.testapp

import android.content.Context
import java.util.*

class ServiceLocator {

    private val locatedMap = HashMap<Class<*>, Any?>()

    fun <T, I : T?> register(clazz: Class<T>, impl: I) {
        locatedMap[clazz] = impl
    }

    fun <T> locate(clazz: Class<T>): T {
        val item = locatedMap[clazz] as T?
        if (item != null) {
            return item
        }
        throw IllegalStateException("cant find locatable for $clazz")
    }

    companion object {
        fun from(context: Context): ServiceLocator {
            return if (context is LocatorHost) {
                (context as LocatorHost).getLocator()
            } else if (context.applicationContext is LocatorHost) {
                (context.applicationContext as LocatorHost).getLocator()
            } else {
                throw IllegalArgumentException()
            }
        }
    }
}