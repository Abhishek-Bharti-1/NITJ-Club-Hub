package com.androrubin.troika.nitjclubhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        val name_txt = findViewById<TextView>(R.id.name_txt)
        name_txt.text = currentUser?.displayName

        val email_txt = findViewById<TextView>(R.id.email_txt)
        email_txt.text = currentUser?.email

        val profile_image = findViewById<ImageView>(R.id.profile_image)
        Glide.with(this).load(currentUser?.photoUrl).into(profile_image)

        val logout = findViewById<Button>(R.id.sign_out_btn)
        logout?.setOnClickListener()
        {
            mAuth.signOut()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }

}