package com.headmost.cleanarch.testapp.usecases.repositories

import com.headmost.cleanarch.testapp.entities.User
import io.reactivex.Observable

interface UserRepository {
    fun getUser(): Observable<User?>
}
