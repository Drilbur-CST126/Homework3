package com.jnich.homework3

import com.google.gson.annotations.SerializedName

data class ArticleOld(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("blurb") val blurb: String,
    @SerializedName("link") val link: String
)