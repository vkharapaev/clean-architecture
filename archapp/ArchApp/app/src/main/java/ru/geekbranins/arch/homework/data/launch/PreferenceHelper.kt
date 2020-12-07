package ru.geekbranins.arch.homework.data.launch

import android.content.Context
import androidx.preference.PreferenceManager
import io.reactivex.Completable
import io.reactivex.Single

class PreferenceHelper(private val context: Context) {

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