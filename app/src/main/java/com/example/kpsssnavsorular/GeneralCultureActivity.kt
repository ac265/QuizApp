package com.example.kpsssnavsorular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GeneralCultureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_cullture)

        var strHeader = intent.getStringExtra("Header")
        var strHeader2 = strHeader +  " Genel Kültür Soruları"

        val header = findViewById<TextView>(R.id.app_bar_header)
        header.text = strHeader2

        val back_icon_click = findViewById<ImageView>(R.id.back_icon)
        back_icon_click.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }
    }
}