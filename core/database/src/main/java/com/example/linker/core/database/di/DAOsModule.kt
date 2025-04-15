package com.example.linker.core.database.di

import com.example.linker.core.database.LinkerDB
import com.example.linker.core.database.dao.GameDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DAOsModule {
    @Provides
    fun providesTopicsDao(
        database: LinkerDB,
    ): GameDAO = database.gameDao()
}