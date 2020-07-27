package com.jnich.homework3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jnich.homework3.model.Article

class RelatedArticles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_related_articles)

        val article = intent.extras!!["EXTRA_ARTICLE"] as Article

        val transaction = supportFragmentManager.beginTransaction()
        val fragment = ArticleList.newInstance(query = article.title)
        transaction.replace(R.id.frg_related, fragment, fragment.toString())
        transaction.commit()
    }
}