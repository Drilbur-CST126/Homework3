package com.jnich.homework3.api


import com.google.gson.annotations.SerializedName
import com.jnich.homework3.model.Article

data class GetArticlesResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)