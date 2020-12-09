package com.headmost.cleanarch.testapp.interfaceadapters.data

import com.headmost.cleanarch.testapp.entities.User
import com.headmost.cleanarch.testapp.usecases.repositories.UserRepository
import io.reactivex.Observable

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override fun getUser(): Observable<User?> {
        return userDataSource.getUser()
    }
}
