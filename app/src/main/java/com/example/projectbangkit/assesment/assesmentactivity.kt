package com.example.projectbangkit.assesment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.example.projectbangkit.R
import com.example.projectbangkit.connection.PredictionRequest
import com.example.projectbangkit.connection.apiconfig
import com.example.projectbangkit.data.LearningTypeResponse
import com.example.projectbangkit.home.homeactivity
import com.example.projectbangkit.result.resultAssesment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class assesmentactivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assesmentactivity)
        val x = findViewById<ImageView>(R.id.kembaliAssesment)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.GONE
        x.setOnClickListener{
            val intent = Intent(this, homeactivity::class.java)
            startActivity(intent)
        }
        val y = findViewById<Button>(R.id.tombolAssesment)

        y.setOnClickListener {
            postPredict()
        }
    }
    private fun postPredict(){
        showProgressBar()
        val predictionRequest = PredictionRequest(findViewById<EditText>(R.id.boxassesment).text.toString().trim())
        apiconfig.apiService.predictLearningType(predictionRequest)
            .enqueue(object : Callback<LearningTypeResponse> {
                override fun onResponse(call: Call<LearningTypeResponse>, response: Response<LearningTypeResponse>) {
                    if (response.isSuccessful) {
                        hideProgressBar()
                        val learningType = response.body()?.data?.learning_type_result
                        val intent = Intent(this@assesmentactivity,resultAssesment::class.java)
                        intent.putExtra("sentence", learningType)
                        startActivity(intent)
                    } else {

                    }
                }

                override fun onFailure(call: Call<LearningTypeResponse>, t: Throwable) {
                    Toast.makeText(this@assesmentactivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()

                }
            })
    }
    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}