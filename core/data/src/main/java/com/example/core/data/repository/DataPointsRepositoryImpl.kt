package com.example.core.data.repository

import com.example.linker.core.database.dao.DataPointDao
import com.example.linker.core.database.model.DataPointEntity
import com.example.linker.core.database.model.asExternalModel
import com.example.linker.core.model.DataPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.random.Random

class DataPointsRepositoryImpl @Inject constructor(
    private val dataPointDao: DataPointDao,
): DataPointsRepository {

    override fun getDataForDataset(name: String): Flow<List<DataPoint>> =
        dataPointDao.getDataForDataset(name)
            .map { it.map(DataPointEntity::asExternalModel) }

    override suspend fun generateTestData() {
        dataPointDao.clearTestData()

        val testData = mutableListOf<DataPointEntity>()
        val now = System.currentTimeMillis()
        val dayInMillis = 24 * 60 * 60 * 1000L

        // تولید داده‌های طلا
        for (i in 0..9) {
            testData.add(
                DataPointEntity(
                    id = i + 1,
                    datasetName = "Gold",
                    timestamp = now - (10 - i) * dayInMillis,
                    value = 1850.00f + (i * 7.5f) + Random.nextFloat() * 5f
                )
            )
        }

        // تولید داده‌های پلاتینیوم
        for (i in 0..9) {
            testData.add(
                DataPointEntity(
                    id = i + 11,
                    datasetName = "Platinum",
                    timestamp = now - (10 - i) * dayInMillis,
                    value = 950.00f + (i * 6.8f) + Random.nextFloat() * 3f
                )
            )
        }

        // تولید داده‌های پالادیوم
        for (i in 0..9) {
            testData.add(
                DataPointEntity(
                    id = i + 21,
                    datasetName = "Palladium",
                    timestamp = now - (10 - i) * dayInMillis,
                    value = 1400.00f + (i * 8.2f) + Random.nextFloat() * 4f
                )
            )
        }

        dataPointDao.insertAll(testData)

    }
}