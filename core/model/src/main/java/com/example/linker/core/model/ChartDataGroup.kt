package com.example.linker.core.model

data class ChartDataGroup(
    val platinum: Platinum,
    val palladium: Palladium,
    val gold: Gold
)


data class Platinum(
    val data: List<DataPoint>,
    val name: String,
    val color: Long
)

data class Palladium(
    val data: List<DataPoint>,
    val name: String,
    val color: Long
)

data class Gold(
    val data: List<DataPoint>,
    val name: String,
    val color: Long
)
