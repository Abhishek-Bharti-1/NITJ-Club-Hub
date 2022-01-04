package com.androrubin.troika.nitjclubhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class CreatePost : AppCompatActivity() {

    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        db= FirebaseFirestore.getInstance()

        val title= findViewById<EditText>(R.id.title3)
        val des = findViewById<EditText>(R.id.descrition_mes)

        var name = intent.getStringExtra("collection_name")

        val submit = findViewById<Button>(R.id.submit)
        submit?.setOnClickListener {

//            Toast.makeText(this,title.getText().toString(),Toast.LENGTH_SHORT).show()
            val data = hashMapOf(
                "title" to title.getText().toString(),
                "description" to des.getText().toString()
            )

            db.collection("$name")
                .add(data)
                .addOnSuccessListener { documentReference ->
                    Log.d("Data Addition", "DocumentSnapshot written with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("Data Addition", "Error adding document", e)
                }
            val intent = Intent(this,MainActivity::class.java)
            Toast.makeText(this,"Post Added",Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}