package com.example.core.data.repository

import com.example.linker.core.database.model.DataPointEntity
import com.example.linker.core.model.DataPoint
import kotlinx.coroutines.flow.Flow

interface DataPointsRepository {

    fun getDataForDataset(name: String): Flow<List<DataPoint>>

}