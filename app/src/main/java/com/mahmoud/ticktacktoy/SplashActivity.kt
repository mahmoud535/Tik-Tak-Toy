package com.mahmoud.ticktacktoy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ////////////////////////////////////////////////////
        //الخاص بالواجهه عند فتح التطبيق لكي يجعل الصوره ملء الشاشه
//        @Suppress("DEPRECATION")
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
//            window.insetsController?.hide(WindowInsets.Type.statusBars())
//        }else{
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN
//            )
//        }

        ////////////////////////////////
        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                finish()
            },
            1500
        )

    }
}