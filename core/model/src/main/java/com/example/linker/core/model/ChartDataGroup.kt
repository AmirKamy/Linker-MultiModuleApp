package com.example.linker.core.model

data class ChartDataGroup(
    val platinum: List<DataPoint>,
    val silver: List<DataPoint>,
    val gold: List<DataPoint>
)
