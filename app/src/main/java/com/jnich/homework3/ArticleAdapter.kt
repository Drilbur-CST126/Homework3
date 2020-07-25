package com.jnich.homework3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(private val context: Context, private val articleList: List<ArticleOld>)
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
        holder.articleName.text = articleList[position].title
        holder.articleAuthor.text = context.getString(R.string.txt_author_descriptor, articleList[position].author)
    }

}