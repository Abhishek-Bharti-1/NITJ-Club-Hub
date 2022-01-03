package com.androrubin.troika.nitjclubhub

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
            Toast.makeText(this,"Abhi nhi chal raha hai", Toast.LENGTH_SHORT).show()
        }
    }
}