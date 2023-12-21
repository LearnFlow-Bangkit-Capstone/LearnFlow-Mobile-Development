package com.example.projectbangkit.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.projectbangkit.R
import com.example.projectbangkit.assesment.assesmentactivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class homeactivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeactivity)
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        val x = findViewById<Button>(R.id.assesment)
        x.setOnClickListener {
            val intent = Intent(this, assesmentactivity::class.java)
            startActivity(intent)
        }

        val welcome = findViewById<TextView>(R.id.hello)
        val currentUser = auth.currentUser?.uid
        if (currentUser != null) {
            firestore.collection("users").document(currentUser)
                .get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot.exists()) {
                        val displayName = documentSnapshot.getString("name")
                        welcome.text = "Hello $displayName"
                    }
                }
        }
    }
}