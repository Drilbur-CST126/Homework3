package com.jnich.homework3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.jnich.homework3.model.Article
import java.util.zip.Inflater

class ArticleAdapter(private val context: Context, private val articleList: MutableList<Article>)
    : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context!!)
            .inflate(R.layout.article_card_view, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val articleName = view.findViewById<TextView>(R.id.txtArticleName)
        val articleAuthor = view.findViewById<TextView>(R.id.txtArticleAuthor)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articleList[position]
        holder.articleName.text = article.title
        holder.articleAuthor.text = context.getString(R.string.txt_author_descriptor, article.author)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, FullArticlePage::class.java)
            intent.putExtra("EXTRA_ARTICLE", article)
            context.startActivity(intent)
        }
    }

    fun addArticles(incoming: List<Article>) {
        articleList.addAll(incoming)
        notifyItemRangeInserted(articleList.size, incoming.size - 1)
    }
}