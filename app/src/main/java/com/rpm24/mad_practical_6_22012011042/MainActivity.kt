package com.rpm24.mad_practical_6_22012011042

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var clockAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgview = findViewById<ImageView>(R.id.img1)
        imgview.setBackgroundResource(R.drawable.clock_animation_list)
        clockAnimation = imgview.background as AnimationDrawable
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            clockAnimation.start()
            //findViewById<ImageView>(R.id.uvpce_imageview).startAnimation(tweenAnimation)
        } else {
            clockAnimation.stop()
        }
    }

    fun onAnimationStart(p0: Animation?) {

    }

    fun onAnimationEnd(p0: Animation?) {
        Intent(this, MainActivity::class.java).also{startActivity(it)}
    }

    fun onAnimationRepeat(p0: Animation?) {

    }
}