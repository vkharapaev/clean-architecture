package ru.geekbrains.arch.homework.data.launch

import io.reactivex.Completable
import io.reactivex.Single
import ru.geekbrains.arch.homework.data.preference.PreferenceHelper
import ru.geekbrains.arch.homework.repository.LaunchCountRepository
import javax.inject.Inject

class LaunchCountRepositoryImpl @Inject constructor(private val preferenceHelper: PreferenceHelper) :
    LaunchCountRepository {

    override fun setLaunchNumber(launchNumber: Int): Completable {
        return preferenceHelper.put(KEY_APP_LAUNCH_NUMBER, launchNumber)
    }

    override fun getLaunchNumber(): Single<Int> {
        return preferenceHelper.getInt(KEY_APP_LAUNCH_NUMBER, 0)
    }

    companion object {
        private const val KEY_APP_LAUNCH_NUMBER: String = "app_launch_number"
    }
}
