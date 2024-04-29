package com.example.match_game

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Type : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_type)

        var backbtn = findViewById<Button>(R.id.home_back)
        backbtn.setOnClickListener {
            var intent = Intent(this,Home::class.java)
            startActivity(intent)
            finish()
        }

        var lettersbtn = findViewById<Button>(R.id.letter_btn)
        lettersbtn.setOnClickListener {
            var intent = Intent(this,game::class.java)
            startActivity(intent)
            finish()
        }


        var numbersbtn = findViewById<Button>(R.id.numbers_btn)
        numbersbtn.setOnClickListener {
            var intent = Intent(this,game2::class.java)
            startActivity(intent)
            finish()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}