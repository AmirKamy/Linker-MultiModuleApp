package com.example.linker.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.linker.core.database.model.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDAO {

    @Query(
        value = """
        SELECT * FROM games
        WHERE id = :gameId
    """,
    )
    fun getGameEntity(gameId: String): Flow<GameEntity>

    @Query(value = "SELECT * FROM games")
    fun getGameEntities(): Flow<List<GameEntity>>

}