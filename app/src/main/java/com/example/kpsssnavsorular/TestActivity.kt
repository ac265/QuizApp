package com.example.kpsssnavsorular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var strHeader = intent.getStringExtra("Header")
        var strHeader2 = intent.getStringExtra("Header") +  " Sınav Soruları"

        val header = findViewById<TextView>(R.id.app_bar_header)
        header.text = strHeader2

        val back_icon_click = findViewById<ImageView>(R.id.back_icon)
        back_icon_click.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            var header = strHeader
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        val all_test_click = findViewById<LinearLayout>(R.id.ly_all_test)
        all_test_click.setOnClickListener {
            val intent = Intent(this, SubTestsActivity::class.java)
            var header = strHeader
            var header2 = strHeader + " Tüm Sınav Soruları"
            intent.putExtra("Header", header)
            intent.putExtra("Header2", header2)
            startActivity(intent)
        }

        val general_culture_click = findViewById<LinearLayout>(R.id.ly_general_culture)
        general_culture_click.setOnClickListener {
            val intent = Intent(this, GeneralCultureActivity::class.java)
            var header = strHeader
            var header2 = strHeader + " Genel Kültür Soruları"
            intent.putExtra("Header", header)
            intent.putExtra("Header2", header2)
            startActivity(intent)
        }

        val general_ability_click = findViewById<LinearLayout>(R.id.ly_general_ability)
        general_ability_click.setOnClickListener {
            val intent = Intent(this, GeneralAbilityActivity::class.java)
            var header = strHeader
            var header2 = strHeader + " Genel Yetenek Soruları"
            intent.putExtra("Header", header)
            intent.putExtra("Header2", header2)
            startActivity(intent)
        }
    }
}