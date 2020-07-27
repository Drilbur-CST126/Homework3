package com.jnich.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_submit.setOnClickListener(::submitSearchQuery)
    }

    private fun submitSearchQuery(view: View) {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = ArticleList.newInstance(query = edit_search.text.toString())
        transaction.replace(R.id.frg_search, fragment, fragment.toString())
        transaction.commit()
    }
}