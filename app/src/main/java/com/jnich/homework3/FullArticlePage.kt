package com.jnich.homework3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jnich.homework3.model.Article
import kotlinx.android.synthetic.main.activity_full_article_page.*
import kotlinx.android.synthetic.main.activity_main.*

class FullArticlePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_article_page)

        val article = intent.extras!!["EXTRA_ARTICLE"] as Article

        txt_title.text = article.title
        txt_author.text = article.author
        txt_content.text = article.content

        val transaction = supportFragmentManager.beginTransaction()
        val fragment = ArticleList.newInstance(query = article.title)
        transaction.replace(R.id.frg_related, fragment, fragment.toString())
        transaction.addToBackStack(fragment.toString())
        transaction.commit()
    }
}