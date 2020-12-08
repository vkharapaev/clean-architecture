package ru.geekbrains.arch.homework.data.photo.model

import com.google.gson.annotations.SerializedName

data class ApiResult(@SerializedName("photos") val photos: ApiPhotoPage)
