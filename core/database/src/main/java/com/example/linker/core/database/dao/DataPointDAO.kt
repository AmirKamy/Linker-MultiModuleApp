package com.example.linker.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.linker.core.database.model.DataPointEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DataPointDao {

    @Query("SELECT * FROM data_points WHERE datasetName = :name ORDER BY timestamp")
    fun getDataForDataset(name: String): Flow<List<DataPointEntity>>

}