package com.headmost.cleanarch.testapp.frameworks.network

import com.headmost.cleanarch.testapp.frameworks.network.model.ApiUser
import io.reactivex.Observable
import retrofit2.http.GET

interface JsonPlaceholderApiService {
    @GET("users")
    fun getUsers(): Observable<List<ApiUser>>
}
