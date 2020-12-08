package com.headmost.cleanarch.testapp.frameworks.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.headmost.cleanarch.testapp.LocatorHost
import com.headmost.cleanarch.testapp.R
import com.headmost.cleanarch.testapp.ServiceLocator
import com.headmost.cleanarch.testapp.entities.User
import com.headmost.cleanarch.testapp.frameworks.network.JsonPlaceHolderApi
import com.headmost.cleanarch.testapp.frameworks.network.UserRemoteDataSource
import com.headmost.cleanarch.testapp.interfaceadapters.data.UserRepositoryImpl
import com.headmost.cleanarch.testapp.interfaceadapters.presenters.UserPresenter
import com.headmost.cleanarch.testapp.interfaceadapters.presenters.UserPresenterImpl
import com.headmost.cleanarch.testapp.interfaceadapters.presenters.UserView
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractor
import com.headmost.cleanarch.testapp.usecases.interactors.UserInteractorImpl

class UserActivity : AppCompatActivity(), UserView, LocatorHost {

    private var presenter: UserPresenter? = null
    private var progressBar: ProgressBar? = null
    private var textView: TextView? = null

    private val userActivityLocator = ServiceLocator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.text)

        registerPresenter()

        presenter = userActivityLocator.locate(UserPresenter::class.java)

        button.setOnClickListener { presenter?.onUserAction() }
    }

    private fun registerPresenter() {
        val userInteractor = ServiceLocator.from(applicationContext).locate(UserInteractor::class.java)
        val userPresenter = UserPresenterImpl(this, userInteractor)
        userActivityLocator.register(UserPresenter::class.java, userPresenter)
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

    override fun showProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar?.visibility = View.INVISIBLE
    }

    override fun showUser(user: User?) {
        Log.i(TAG, "showUser: $user")
        textView?.text = user?.name
    }

    override fun showError() {
        textView?.text = "Error!"
    }

    override fun showResult() {
        textView?.text = "Result"
    }

    companion object {
        private const val TAG = "UserActivity"
    }

    override fun getLocator(): ServiceLocator {
        return userActivityLocator
    }

}
