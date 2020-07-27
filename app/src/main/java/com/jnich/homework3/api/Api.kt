package com.jnich.homework3.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("everything")
    fun getArticleResult(
        @Query("q") query: String? = null,
        @Query("domains") website: String? = null,
        @Query("apiKey") apiKey: String = "8c161060c701474cbace2256c0df80b4"
    ): Call<GetArticlesResponse>
}