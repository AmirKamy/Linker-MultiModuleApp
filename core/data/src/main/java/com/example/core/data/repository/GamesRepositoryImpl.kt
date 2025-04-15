package com.example.core.data.repository

import com.example.linker.core.database.dao.GameDAO
import com.example.linker.core.database.model.GameEntity
import com.example.linker.core.database.model.asExternalModel
import com.example.linker.core.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class GamesRepositoryImpl @Inject constructor(
    private val gameDao: GameDAO,
): GamesRepository {

    override fun getGames(): Flow<List<Game>> =
        gameDao.getGameEntities()
            .map { it.map(GameEntity::asExternalModel) }

    override fun getGame(id: String): Flow<Game> =
        gameDao.getGameEntity(id).map { it.asExternalModel() }
}