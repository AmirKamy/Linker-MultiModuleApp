package com.example.linker.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.linker.core.model.DataPoint

@Entity(tableName = "data_points")
data class DataPointEntity(
    @PrimaryKey()
    val id: Int,
    val datasetName: String,
    val timestamp: Long,
    val value: Float
)

fun DataPointEntity.asExternalModel() = DataPoint(
    id = id,
    datasetName = datasetName,
    timestamp = timestamp,
    value = value
)

