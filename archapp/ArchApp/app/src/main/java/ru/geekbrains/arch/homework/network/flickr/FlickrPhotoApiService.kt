package ru.geekbrains.arch.homework.network.flickr

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.geekbrains.arch.homework.data.photo.model.ApiResult

interface FlickrPhotoApiService {

    @GET("services/rest")
    fun getRecent(
        @Query("method") method: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: String,
        @Query("per_page") perPage: Int,
        @Query("page") pageNumber: Int,
        @Query("extras") extras: String
    ): Single<ApiResult>
}