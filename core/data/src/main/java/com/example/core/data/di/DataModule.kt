package com.example.core.data.di

import com.example.core.data.repository.DataPointsRepository
import com.example.core.data.repository.DataPointsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsDataPointRepository(
        gamesRepository: DataPointsRepositoryImpl,
    ): DataPointsRepository


}