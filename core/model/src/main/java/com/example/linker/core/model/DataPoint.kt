package com.example.linker.core.model

data class DataPoint(
    val id: Int,
    val datasetName: String,
    val timestamp: Long,
    val value: Float
)
