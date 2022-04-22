package com.example.app_sounds_animals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val animacion1: Animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)

        val porText: TextView = findViewById(R.id.por)
        val ollinText: TextView = findViewById(R.id.ollin)
        val logo: ImageView = findViewById(R.id.logo)

        porText.animation = animacion1
        ollinText.animation = animacion1
        logo.animation = animacion1

        Handler().postDelayed(Runnable {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}