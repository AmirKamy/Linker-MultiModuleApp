package com.example.core.data.repository

import com.example.linker.core.database.dao.DataPointDao
import com.example.linker.core.database.model.DataPointEntity
import com.example.linker.core.database.model.asExternalModel
import com.example.linker.core.model.DataPoint
import com.example.linker.core.model.Product
import com.linker.core.network.LinkerNetworkDataSource
import com.linker.core.network.model.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.random.Random

class DataPointsRepositoryImpl @Inject constructor(
    private val network: LinkerNetworkDataSource,
): DataPointsRepository {

    override fun getDataForDataset(): Flow<List<Product>> = flow {
        val result = network.getAllProducts()
        emit(result.map { it.asExternalModel() })
    }
}