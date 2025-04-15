package com.example.linker.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.linker.core.model.Game

@Entity(
    tableName = "games",
)
data class GameEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
)

fun GameEntity.asExternalModel() = Game(
    id = id,
    name = name,
    description = description,
    imageUrl = imageUrl,
)