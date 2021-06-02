package com.cyberinsane.spacex.company.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "elon_twitter")
    val elonTwitter: String = "",
    @Json(name = "flickr")
    val flickr: String = "",
    @Json(name = "twitter")
    val twitter: String = "",
    @Json(name = "website")
    val website: String = ""
)
