package com.headmost.cleanarch.testapp.usecases.interactors

import com.headmost.cleanarch.testapp.entities.User
import com.headmost.cleanarch.testapp.usecases.repositories.UserRepository
import io.reactivex.Observable


class UserInteractorImpl(private val userRepository: UserRepository) : UserInteractor {
    override fun getUser(): Observable<User?> {
        return userRepository.getUser()
    }
}
