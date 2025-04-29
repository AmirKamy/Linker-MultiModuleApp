package com.linker.core.domain

import com.example.core.data.repository.DataPointsRepository
import com.example.linker.core.model.ChartDataGroup
import com.example.linker.core.model.Gold
import com.example.linker.core.model.Palladium
import com.example.linker.core.model.Platinum
import com.example.linker.core.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetChartDataGroupUseCase @Inject constructor(private val repository: DataPointsRepository) {
    operator fun invoke(): Flow<List<Product>> {

        return repository.getDataForDataset()

    }
}