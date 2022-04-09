package com.miu.resume

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences("RESUME", Context.MODE_PRIVATE)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            startActivity(Intent(this, ResumeActivity::class.java))
        }

        if (!isSeenOnbaord()) {
            startActivity(Intent(this, ResumeActivity::class.java))
        }
    }

    fun isSeenOnbaord(): Boolean {
        return preferences.getBoolean("ISCOMPLETE", false)
    }
}