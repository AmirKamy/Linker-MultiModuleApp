package com.linker.core.domain

import com.example.core.data.repository.DataPointsRepository
import com.example.linker.core.model.ChartDataGroup
import com.example.linker.core.model.Gold
import com.example.linker.core.model.Palladium
import com.example.linker.core.model.Platinum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetChartDataGroupUseCase @Inject constructor(private val repository: DataPointsRepository) {
    operator fun invoke(): Flow<ChartDataGroup> {

        val platinum = repository.getDataForDataset("Platinum")
        val palladium = repository.getDataForDataset("Palladium")
        val gold = repository.getDataForDataset("Gold")

        return combine(platinum, palladium, gold) { d1, d2, d3 ->
            ChartDataGroup(
                platinum = Platinum(d1, "پلاتینیوم", 0xFFB0C4DE),
                palladium = Palladium(d2, "پالادیوم", 0xFF9E9E9E),
                gold = Gold(d3, "طلا", 0xFFFFD700)
            )
        }

    }
}