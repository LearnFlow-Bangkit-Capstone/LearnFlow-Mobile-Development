package com.example.projectbangkit.data

data class LearningTypeResponse(val data: LearningTypeData, val status: Status)
data class LearningTypeData(val learning_type_result: String)
data class Status(val code: Int, val message: String)
