package com.example.linker.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.linker.core.database.model.DataPointEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DataPointDao {

    @Query("SELECT * FROM data_points WHERE datasetName = :name ORDER BY timestamp")
    fun getDataForDataset(name: String): Flow<List<DataPointEntity>>

    // متد جدید برای درج داده‌های تست
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dataPoints: List<DataPointEntity>)

    // متد کمکی برای پاک کردن داده‌های تست (اختیاری)
    @Query("DELETE FROM data_points WHERE datasetName IN ('Gold', 'Platinum', 'Palladium')")
    suspend fun clearTestData()

}