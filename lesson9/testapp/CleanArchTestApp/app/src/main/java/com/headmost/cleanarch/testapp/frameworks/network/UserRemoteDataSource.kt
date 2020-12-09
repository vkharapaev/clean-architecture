package com.headmost.cleanarch.testapp.frameworks.network

import com.headmost.cleanarch.testapp.entities.User
import com.headmost.cleanarch.testapp.frameworks.network.model.ApiUser
import com.headmost.cleanarch.testapp.interfaceadapters.data.UserDataSource
import io.reactivex.Observable

class UserRemoteDataSource(private val jsonPlaceHolderApi: JsonPlaceHolderApi) : UserDataSource {
    override fun getUser(): Observable<User?> {
        return jsonPlaceHolderApi.getJsonplaceholderApiService().getUsers()
            .map { apiUsers -> mapUsers(apiUsers) }
            .map { users -> users[0] }
    }

    private fun mapUsers(apiUsers: List<ApiUser>): List<User?> {
        val users = ArrayList<User>(apiUsers.size)
        apiUsers.stream().forEach { apiUser ->
            users.add(
                User(
                    apiUser.name,
                    apiUser.username,
                    apiUser.email,
                    apiUser.phone, apiUser.address.city
                )
            )
        }
        return users
    }
}
