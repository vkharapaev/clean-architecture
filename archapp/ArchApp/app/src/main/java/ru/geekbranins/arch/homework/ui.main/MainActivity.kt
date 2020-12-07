package ru.geekbranins.arch.homework.ui.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ru.geekbranins.arch.homework.R
import ru.geekbranins.arch.homework.data.launch.LaunchCountRepositoryImpl
import ru.geekbranins.arch.homework.data.launch.PreferenceHelper
import ru.geekbranins.arch.homework.interactor.main.MainInteractorImpl
import ru.geekbranins.arch.homework.util.LoggerImpl

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

    companion object {
        private const val TAG = "Main"
    }

}