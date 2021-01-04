package com.headmost.cleanarch.testapp.frameworks.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiUser(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("username") @Expose val username: String,
    @SerializedName("email") @Expose val email: String,
    @SerializedName("address") @Expose val address: ApiAddress,
    @SerializedName("phone") @Expose val phone: String,
    @SerializedName("website") @Expose val website: String,
    @SerializedName("company") @Expose val company: ApiCompany
)
