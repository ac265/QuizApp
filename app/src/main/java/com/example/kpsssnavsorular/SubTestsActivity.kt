package com.example.kpsssnavsorular

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.core.view.isVisible

var switchFlag : Int = 0

class SubTestsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_tests)

        var strHeader = intent.getStringExtra("Header")
        var strHeader2 = strHeader +  " Tüm Sınav Soruları"

        val header = findViewById<TextView>(R.id.app_bar_header)
        header.text = strHeader2

        val startTestButton_click = findViewById<Button>(R.id.startTestButton)
        val continueTestButton_click = findViewById<Button>(R.id.continueTestButton)
        val timerEnableTextView = findViewById<Switch>(R.id.timerEnableTextView)
        val back_icon_click = findViewById<ImageView>(R.id.back_icon)

        back_icon_click.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

        if(indexFlag == 0)
        {
            continueTestButton_click.isVisible = false
            startTestButton_click.text = "Teste Başla"
        }

        else
        {
            continueTestButton_click.isVisible = true
            startTestButton_click.text = "Teste Yeniden Başla"
        }

        startTestButton_click.setOnClickListener {

            answerList.clear();
            val intent = Intent(this, AllTestActivity::class.java)
            var header = strHeader
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        continueTestButton_click.setOnClickListener {
            val intent = Intent(this, AllTestActivity::class.java)
            var header = strHeader
            intent.putExtra("Header", header)
            startActivity(intent)
        }

        if(timerEnableTextView.isChecked)
        {
            switchFlag = 1;
        }

        timerEnableTextView?.setOnCheckedChangeListener({ _ , isChecked ->
            val message = if (isChecked) "Zamanlayıcı: Açık" else "Zamanlayıcı: Kapalı"

            if(isChecked)
            {
                switchFlag = 1;
            }

            else
            {
                switchFlag = 0;
            }
            Toast.makeText(this , message, Toast.LENGTH_SHORT).show()
        })
    }
}