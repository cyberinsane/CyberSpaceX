package com.cyberinsane.spacex.company.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Headquarters(
    @Json(name = "address")
    val address: String = "",
    @Json(name = "city")
    val city: String = "",
    @Json(name = "state")
    val state: String = ""
)
