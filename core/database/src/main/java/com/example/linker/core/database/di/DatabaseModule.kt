package com.example.linker.core.database.di

import android.content.Context
import androidx.room.Room
import com.example.linker.core.database.LinkerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesLinkerDatabase(
        @ApplicationContext context: Context,
    ): LinkerDB = Room.databaseBuilder(
        context,
        LinkerDB::class.java,
        "linker-database",
    )
        .build()
}