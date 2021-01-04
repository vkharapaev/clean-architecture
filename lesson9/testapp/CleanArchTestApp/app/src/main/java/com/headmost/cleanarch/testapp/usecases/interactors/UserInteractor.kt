package com.headmost.cleanarch.testapp.usecases.interactors

import com.headmost.cleanarch.testapp.entities.User
import io.reactivex.Observable

interface UserInteractor {
    fun getUser(): Observable<User?>
}
