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
import ru.geekbrains.arch.homework.di.MainModule
import ru.geekbrains.arch.homework.di.Scopes
import ru.geekbrains.arch.homework.domain.Photo
import ru.geekbrains.arch.homework.interactor.main.MainInteractorImpl
import ru.geekbrains.arch.homework.network.ApiKeyProvider
import ru.geekbrains.arch.homework.network.flickr.FlickrApi
import ru.geekbrains.arch.homework.network.flickr.FlickrApiKeyProvider
import ru.geekbrains.arch.homework.network.flickr.FlickrHostProvider
import ru.geekbrains.arch.homework.ui.search.SearchPhotoFragment
import ru.geekbrains.arch.homework.util.logger.LoggerImpl
import ru.geekbrains.arch.homework.util.resources.ResourceManager
import ru.geekbrains.arch.homework.util.resources.ResourceManagerImpl
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scope = Toothpick.openScopes(Scopes.APP, Scopes.MAIN)
        scope.installModules(MainModule(this))
        Toothpick.inject(this, scope)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, SearchPhotoFragment())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()

        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()

        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toothpick.closeScope(Scopes.MAIN)
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

    companion object {
        private const val TAG = "Main"
    }

}