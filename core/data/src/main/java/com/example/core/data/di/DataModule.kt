package com.example.core.data.di

import com.example.core.data.repository.GamesRepository
import com.example.core.data.repository.GamesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsGamesRepository(
        gamesRepository: GamesRepositoryImpl,
    ): GamesRepository


}