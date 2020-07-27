package com.jnich.homework3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_article_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "query"
private const val ARG_PARAM2 = "website"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleList.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleList : Fragment() {
    private var query: String? = null
    private var website: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            query = it.getString(ARG_PARAM1)
            website = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerArticleList.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        val adapter = ArticleAdapter(context!!, ArrayList())
        ArticleRepository.getArticleResults(
            query = query,
            website = website,
            onSuccess = {
                adapter.addArticles(it)
            },
            onError = { Log.d("ArticleList", "Failed to get articles")})

        recyclerArticleList.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param query The search term to use.
         * @param website The website domain to search.
         * @return A new instance of fragment ArticleList.
         */
        @JvmStatic
        fun newInstance(query: String? = null, website: String? = null) =
            ArticleList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, query)
                    putString(ARG_PARAM2, website)
                }
            }
    }
}