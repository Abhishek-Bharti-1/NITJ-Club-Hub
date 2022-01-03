package com.androrubin.troika.nitjclubhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CreatePost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        val submit = findViewById<Button>(R.id.submit)
        submit?.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            Toast.makeText(this,"Post Added",Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}