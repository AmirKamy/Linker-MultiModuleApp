package com.example.linker.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.linker.core.database.dao.DataPointDao
import com.example.linker.core.database.model.DataPointEntity

@Database(
    entities = [DataPointEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class LinkerDB : RoomDatabase() {
    abstract fun dataPointDao(): DataPointDao
}