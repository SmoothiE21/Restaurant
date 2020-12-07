package com.example.restaurant_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
        class SplashActiveKotlin : AppCompatActivity(){
            private val handler = Handler()
            override fun onCreate(
                savedInstanceState: Bundle?,
                persistentState: PersistableBundle?
            ) {
                super.onCreate(savedInstanceState, persistentState)
            }
            private val runnable = Runnable {
                if(!isFinishing){
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                    finish()
                }
            }

            override fun onResume() {
                super.onResume()
                handler.postDelayed(runnable, 2000)
            }

            override fun onPause() {
                super.onPause()
                handler.removeCallbacks(runnable)
            }

        }

    }
}