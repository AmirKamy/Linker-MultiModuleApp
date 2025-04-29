package com.linker.core.network.di

import com.linker.core.network.retrofit.RetrofitLinkerNetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val LINKER_BASE_URL = "https://fakestoreapi.com/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(LINKER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideLinkerNetworkApi(retrofit: Retrofit): RetrofitLinkerNetworkApi =
        retrofit.create(RetrofitLinkerNetworkApi::class.java)
}

