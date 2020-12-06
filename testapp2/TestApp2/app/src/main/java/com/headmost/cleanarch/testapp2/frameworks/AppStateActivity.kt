package com.headmost.cleanarch.testapp2.frameworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.headmost.cleanarch.testapp2.R
import com.headmost.cleanarch.testapp2.adapters.AppStatePresenter
import com.headmost.cleanarch.testapp2.adapters.AppStatePresenterImpl
import com.headmost.cleanarch.testapp2.adapters.AppStateRepositoryImpl
import com.headmost.cleanarch.testapp2.adapters.AppStateView
import com.headmost.cleanarch.testapp2.usecases.AppStateInteractorImpl

class AppStateActivity : AppCompatActivity(), AppStateView {

    private var presenter: AppStatePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createPresenter()
    }

    private fun createPresenter() {
        val appStateDataSource = AppStateDataSourceImpl(this)
        val appStateRepository = AppStateRepositoryImpl(appStateDataSource)
        val appStateInteractor = AppStateInteractorImpl(appStateRepository)
        presenter = AppStatePresenterImpl(appStateInteractor, this)
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

    override fun showRateAppDialog() {
        Toast.makeText(this, "Please, rate this TestApp", Toast.LENGTH_SHORT).show()
    }
}