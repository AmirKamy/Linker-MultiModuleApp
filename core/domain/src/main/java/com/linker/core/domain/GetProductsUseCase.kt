package com.linker.core.domain

import com.example.core.data.repository.ProductsRepository
import com.example.linker.core.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetChartDataGroupUseCase @Inject constructor(private val repository: ProductsRepository) {
    operator fun invoke(): Flow<List<Product>> {

        return repository.getDataForDataset()

    }
}