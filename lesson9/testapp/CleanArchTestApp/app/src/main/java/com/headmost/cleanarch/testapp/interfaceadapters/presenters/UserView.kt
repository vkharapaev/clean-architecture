package com.headmost.cleanarch.testapp.interfaceadapters.presenters

import com.headmost.cleanarch.testapp.entities.User

interface UserView {
    fun showProgress()
    fun hideProgress()
    fun showUser(user: User?)
    fun showError()
    fun showResult()
}
