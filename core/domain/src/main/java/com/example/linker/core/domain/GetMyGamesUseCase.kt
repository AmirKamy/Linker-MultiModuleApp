package com.example.linker.core.domain

import com.example.core.data.repository.GamesRepository
import com.example.linker.core.model.Game
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetMyGamesUseCase @Inject constructor(private val repository: GamesRepository) {
    operator fun invoke(): Flow<List<Game>> {
        // if any process for business logic
        return repository.getGames()
    }
}