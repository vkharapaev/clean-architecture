package com.headmost.cleanarch.testapp.frameworks.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiGeo(
    @SerializedName("lat") @Expose val lat: Float,
    @SerializedName("lng") @Expose val lng: Float
)
