package com.example.linker.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.linker.core.database.dao.GameDAO
import com.example.linker.core.database.model.GameEntity

@Database(
    entities = [GameEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class LinkerDB : RoomDatabase() {
    abstract fun gameDao(): GameDAO
}