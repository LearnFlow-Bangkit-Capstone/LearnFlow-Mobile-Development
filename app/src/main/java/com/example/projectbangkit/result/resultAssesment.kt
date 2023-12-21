package com.example.projectbangkit.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.projectbangkit.R
import org.w3c.dom.Text

class resultAssesment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_assesment)

        val reciver = intent.getStringExtra("sentence")

        val textView = findViewById<TextView>(R.id.resultAssesment)
        textView.text = reciver
    }
}