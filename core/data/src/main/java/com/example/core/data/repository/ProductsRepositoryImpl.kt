package com.example.core.data.repository

import com.example.linker.core.model.Product
import com.linker.core.network.LinkerNetworkDataSource
import com.linker.core.network.model.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val network: LinkerNetworkDataSource,
): ProductsRepository {

    override fun getDataForDataset(): Flow<List<Product>> = flow {
        val result = network.getAllProducts()
        emit(result.map { it.asExternalModel() })
    }
}