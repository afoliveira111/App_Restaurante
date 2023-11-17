package com.example.app_restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnMenu = findViewById<Button>(R.id.btnmenu)

        btnMenu.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)


        }

    }

}
