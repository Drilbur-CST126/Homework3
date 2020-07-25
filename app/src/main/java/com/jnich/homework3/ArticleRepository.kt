package com.jnich.homework3

import android.util.Log
import com.jnich.homework3.api.Api
import com.jnich.homework3.api.GetArticlesResponse
import com.jnich.homework3.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

object ArticleRepository {
    private val api : Api

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }

    fun getArticleResults(
        query: String? = null,
        website: String? = null,
        onSuccess: (articleResults: List<Article>) -> Unit,
        onError: () -> Unit
    ) {
        api.getArticleResult(query = query, website = website)
            .enqueue(object: Callback<GetArticlesResponse> {
                override fun onFailure(call: Call<GetArticlesResponse>, t: Throwable) {
                    Log.d("PostRepository", t.message.toString())
                    onError.invoke()
                }

                override fun onResponse(
                    call: Call<GetArticlesResponse>,
                    response: Response<GetArticlesResponse>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body()

                        if (body != null) {
                            onSuccess(body.articles)
                        } else {
                            Log.d("PostRepository", "Empty body")
                            onError.invoke()
                        }
                    } else {
                        Log.d("PostRepository", "Unsuccessful response")
                        onError.invoke()
                    }
                }

            })
    }
}