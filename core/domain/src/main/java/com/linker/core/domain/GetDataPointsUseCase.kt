package com.linker.core.domain

import com.example.core.data.repository.DataPointsRepository
import com.example.linker.core.model.ChartDataGroup
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetChartDataGroupUseCase @Inject constructor(private val repository: DataPointsRepository) {
    operator fun invoke(): Flow<ChartDataGroup> {
        val dataset1Flow = repository.getDataForDataset("platinum")
        val dataset2Flow = repository.getDataForDataset("silver")
        val dataset3Flow = repository.getDataForDataset("gold")

        return combine(dataset1Flow, dataset2Flow, dataset3Flow) { d1, d2, d3 ->
            ChartDataGroup(
                platinum = d1,
                silver = d2,
                gold = d3
            )
        }

    }
}