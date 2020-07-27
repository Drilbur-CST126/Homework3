package com.jnich.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_submit.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            val fragment = ArticleList.newInstance(query = edit_search.text.toString())
            transaction.replace(R.id.frg_search, fragment, fragment.toString())
            transaction.commit()
        }
    }
}