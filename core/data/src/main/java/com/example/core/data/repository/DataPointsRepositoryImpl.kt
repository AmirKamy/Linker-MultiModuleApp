package com.example.core.data.repository

import com.example.linker.core.database.dao.DataPointDao
import com.example.linker.core.database.model.DataPointEntity
import com.example.linker.core.database.model.asExternalModel
import com.example.linker.core.model.DataPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataPointsRepositoryImpl @Inject constructor(
    private val dataPointDao: DataPointDao,
): DataPointsRepository {

    override fun getDataForDataset(name: String): Flow<List<DataPoint>> =
        dataPointDao.getDataForDataset(name)
            .map { it.map(DataPointEntity::asExternalModel) }


}