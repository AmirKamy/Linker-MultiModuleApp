package com.example.core.data.repository

import com.example.linker.core.model.Game
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
    /**
     * Gets the available games as a stream
     */
    fun getGames(): Flow<List<Game>>

    /**
     * Gets data for a specific game
     */
    fun getGame(id: String): Flow<Game>
}