package com.headmost.cleanarch.testapp.interfaceadapters.data

import com.headmost.cleanarch.testapp.entities.User
import io.reactivex.Observable

interface UserDataSource {
    fun getUser(): Observable<User?>
}
