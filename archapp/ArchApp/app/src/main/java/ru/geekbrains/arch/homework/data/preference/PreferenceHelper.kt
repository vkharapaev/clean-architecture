package ru.geekbrains.arch.homework.data.preference

import android.content.Context
import androidx.preference.PreferenceManager
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PreferenceHelper @Inject constructor(private val context: Context) {

    fun put(paramKey: String, value: Int): Completable {
        return Completable.fromAction {
            PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(paramKey, value)
                .apply()
        }
    }

    fun getInt(paramKey: String, defaultValue: Int): Single<Int> {
        return Single.fromCallable {
            PreferenceManager.getDefaultSharedPreferences(context).getInt(paramKey, defaultValue)
        }
    }
}
