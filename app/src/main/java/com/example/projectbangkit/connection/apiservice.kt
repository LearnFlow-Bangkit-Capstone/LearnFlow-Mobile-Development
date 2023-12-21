package com.example.projectbangkit.connection

import com.example.projectbangkit.data.LearningTypeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface apiservice {
    @POST("predict")
    fun predictLearningType(@Body request: PredictionRequest): Call<LearningTypeResponse>
}

data class PredictionRequest(val sentence: String)