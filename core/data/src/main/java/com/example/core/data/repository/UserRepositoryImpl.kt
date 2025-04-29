package com.example.core.data.repository

import com.example.linker.core.database.dao.DataPointDao
import com.example.linker.core.model.Login
import com.example.linker.core.model.LoginToServer
import com.linker.core.network.LinkerNetworkDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val network: LinkerNetworkDataSource,
): UserRepository {




}