package com.headmost.cleanarch.testapp2.frameworks

import android.app.Activity
import android.content.Context
import com.headmost.cleanarch.testapp2.R
import com.headmost.cleanarch.testapp2.adapters.AppStateDataSource
import com.headmost.cleanarch.testapp2.entities.AppState

class AppStateDataSourceImpl(private val activity: Activity) : AppStateDataSource {

    override fun getAppState(): AppState {
        val preferences = activity.getPreferences(Context.MODE_PRIVATE)
        val runCountDefValue =
            activity.resources.getInteger(R.integer.saved_app_state_run_count_default_key)
        val runCountValue = preferences.getInt(
            activity.getString(R.string.saved_app_state_run_count_key),
            runCountDefValue
        )
        return AppState(runCountValue)
    }

    override fun setAppState(state: AppState) {
        val preferences = activity.getPreferences(Context.MODE_PRIVATE)
        with(preferences.edit()) {
            putInt(activity.getString(R.string.saved_app_state_run_count_key), state.runCount)
            apply()
        }
    }

}