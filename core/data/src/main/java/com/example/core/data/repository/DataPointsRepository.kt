package com.example.core.data.repository

import com.example.linker.core.database.model.DataPointEntity
import com.example.linker.core.model.DataPoint
import com.example.linker.core.model.Product
import kotlinx.coroutines.flow.Flow

interface DataPointsRepository {

    fun getDataForDataset(): Flow<List<Product>>

}