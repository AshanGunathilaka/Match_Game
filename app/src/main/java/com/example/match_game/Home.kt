package com.example.match_game

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        var helpbtn = findViewById<ImageView>(R.id.helpbtn)
        helpbtn.setOnClickListener {
            var intent = Intent(this,Launch01::class.java)
            startActivity(intent)
            finish()
        }

        var btnnext = findViewById<Button>(R.id.playbtn)
        btnnext.setOnClickListener {
            var intent = Intent(this,Type::class.java)
            startActivity(intent)
            finish()
        }

        var scorebtn = findViewById<Button>(R.id.scorebtnn)
        scorebtn.setOnClickListener {
            var intent = Intent(this,score_page::class.java)
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