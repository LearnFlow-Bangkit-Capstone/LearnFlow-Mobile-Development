package com.example.projectbangkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.projectbangkit.Login.loginActivity
import com.example.projectbangkit.registerFolder.register
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val x = findViewById<Button>(R.id.registerAwal)
        val y = findViewById<Button>(R.id.loginAwal)

        x.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
        y.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

    }

}