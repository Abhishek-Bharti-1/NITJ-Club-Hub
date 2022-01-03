package com.androrubin.troika.nitjclubhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class SplashScreen : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val hide = supportActionBar?.hide()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val image: ImageView = findViewById(R.id.imageView)
        val imageAnimation = AnimationUtils.loadAnimation(this, R.anim.image_anim)
        image.startAnimation(imageAnimation)

        val name: TextView = findViewById(R.id.app_name)
        val textAnimation = AnimationUtils.loadAnimation(this,R.anim.text_anim)
        name.startAnimation(textAnimation)


        val slogan: TextView = findViewById(R.id.slogan)
        val textAnimation2 = AnimationUtils.loadAnimation(this,R.anim.text_anim2)
        slogan.startAnimation(textAnimation2)


        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        if(user != null){
            Handler().postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
            },800)
        }
           else{
            Handler().postDelayed({
                val signInintent = Intent(this,LoginActivity::class.java)
                startActivity(signInintent)
                finish()
            },2500)
        }
    }
}