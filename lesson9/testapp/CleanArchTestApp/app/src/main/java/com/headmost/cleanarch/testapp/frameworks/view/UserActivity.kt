package com.headmost.cleanarch.testapp.frameworks.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.headmost.cleanarch.testapp.R
import com.headmost.cleanarch.testapp.di.AppModuleProvider
import com.headmost.cleanarch.testapp.di.UserActivityInjector
import com.headmost.cleanarch.testapp.di.UserActivityModule
import com.headmost.cleanarch.testapp.entities.User
import com.headmost.cleanarch.testapp.interfaceadapters.presenters.UserPresenter
import com.headmost.cleanarch.testapp.interfaceadapters.presenters.UserView

class UserActivity : AppCompatActivity(), UserView {

    private var presenter: UserPresenter? = null
    private var progressBar: ProgressBar? = null
    private var textView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.text)

        UserActivityInjector().inject(this)

        button.setOnClickListener { presenter?.onUserAction() }
    }

    fun setPresenter(userPresenter: UserPresenter) {
        presenter = userPresenter
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

}
