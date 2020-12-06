package com.headmost.cleanarch.testapp.frameworks.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiAddress(
    @SerializedName("street") @Expose val name: String,
    @SerializedName("suite") @Expose val suite: String,
    @SerializedName("city") @Expose val city: String,
    @SerializedName("zipcode") @Expose val zipcode: String,
    @SerializedName("geo") @Expose val geo: ApiGeo
)
