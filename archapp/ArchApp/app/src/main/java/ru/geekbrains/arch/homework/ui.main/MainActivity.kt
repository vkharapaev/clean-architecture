package ru.geekbrains.arch.homework.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.geekbrains.arch.homework.R
import ru.geekbrains.arch.homework.data.launch.LaunchCountRepositoryImpl
import ru.geekbrains.arch.homework.data.photo.PhotoDataSourceImpl
import ru.geekbrains.arch.homework.data.photo.PhotosRepositoryImpl
import ru.geekbrains.arch.homework.data.photo.model.PhotoResultMapper
import ru.geekbrains.arch.homework.data.preference.PreferenceHelper
import ru.geekbrains.arch.homework.domain.Photo
import ru.geekbrains.arch.homework.interactor.main.MainInteractorImpl
import ru.geekbrains.arch.homework.network.ApiKeyProvider
import ru.geekbrains.arch.homework.network.flickr.FlickrApi
import ru.geekbrains.arch.homework.network.flickr.FlickrApiKeyProvider
import ru.geekbrains.arch.homework.network.flickr.FlickrHostProvider
import ru.geekbrains.arch.homework.util.logger.LoggerImpl
import ru.geekbrains.arch.homework.util.resources.ResourceManager
import ru.geekbrains.arch.homework.util.resources.ResourceManagerImpl

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()

        presenter.onStart()

        testGettingPhotos()
    }

    override fun onStop() {
        super.onStop()

        presenter.onStop()
    }

    private fun createPresenter(): MainPresenter {
        val preferenceHelper = PreferenceHelper(this.applicationContext)
        val launchCountRepository = LaunchCountRepositoryImpl(preferenceHelper)
        val mainInteractor = MainInteractorImpl(launchCountRepository)
        val logger = LoggerImpl()
        return MainPresenterImpl(this, mainInteractor, logger)
    }

    override fun showRateProposal() {
        createProposalDialog().show()
    }

    private fun createProposalDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Would you rate our app in Google Play?")
            .setPositiveButton("Rate") { _, _ -> presenter.onRatePositive() }
            .setNegativeButton("Not now") { _, _ -> presenter.onRateNegative() }
        return builder.create()
    }

    // TODO: 09.12.2020 remove it
    private fun testGettingPhotos() {
        val resourceManager = ResourceManagerImpl(this.applicationContext)
        val apiKeyProvider = FlickrApiKeyProvider(resourceManager)
        val hostProvider = FlickrHostProvider(resourceManager)
        val flickrApi = FlickrApi(hostProvider)
        val photoResultMapper = PhotoResultMapper()
        val photoDataSource =
            PhotoDataSourceImpl(flickrApi.getService(), apiKeyProvider, photoResultMapper)
        val photosRepository = PhotosRepositoryImpl(photoDataSource)
        photosRepository.getRecent(0, 100)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Photo>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onSuccess(photos: List<Photo>) {
                    Log.i(TAG, "onSuccess: Got photos: ${photos.size} $photos")
                }

                override fun onError(e: Throwable) {
                    Log.i(TAG, "onError: Error getting photos", e)
                }

            })
    }

    companion object {
        private const val TAG = "Main"
    }

}