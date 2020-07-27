package com.jnich.homework3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jnich.homework3.model.Article
import kotlinx.android.synthetic.main.activity_full_article_page.*

class FullArticlePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_article_page)

        val article = intent.extras!!["EXTRA_ARTICLE"] as Article

        txt_title.text = article.title
        txt_author.text = getString(R.string.txt_author_descriptor, article.author)
        txt_content.text = article.content

        btn_related_articles.setOnClickListener {
            val intent = Intent(this, RelatedArticles::class.java)
            intent.putExtra("EXTRA_ARTICLE", article)
            startActivity(intent)
        }
    }
}