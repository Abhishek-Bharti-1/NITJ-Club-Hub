package com.androrubin.troika.nitjclubhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GroupView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_view)

        val hide = supportActionBar?.hide()

        val recyclerView =  findViewById<RecyclerView>(R.id.recyclerview2)
        val adapter = MyAdaptor2()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val post = findViewById<ImageButton>(R.id.post)
        post?.setOnClickListener {

            val intent2 = Intent(this,CreatePost::class.java)
            startActivity(intent2)
        }
        val page_name = findViewById<TextView>(R.id.page_name)
        page_name.text = intent.getStringExtra("Grp_name")
    }
}