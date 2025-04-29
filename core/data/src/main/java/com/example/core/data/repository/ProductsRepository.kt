package com.example.core.data.repository

import com.example.linker.core.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getDataForDataset(): Flow<List<Product>>

}