package com.example.match_game

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Launch03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_launch03)

        var btnnext = findViewById<Button>(R.id.nextbtn03)
        btnnext.setOnClickListener {
            var intent = Intent(this,Home::class.java)
            startActivity(intent)
            finish()
        }

        var bckbtn = findViewById<TextView>(R.id.backbtn03)
        bckbtn.setOnClickListener {
            var intent = Intent(this,Launch02::class.java)
            startActivity(intent)
            finish()
        }
        var skipbtn = findViewById<TextView>(R.id.skipbtn03)
        skipbtn.setOnClickListener {
            var intent = Intent(this,Home::class.java)
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