package com.linker.core.network

import com.linker.core.network.model.LoginResponse
import com.example.linker.core.model.LoginToServer
import com.linker.core.network.model.ProductDto

interface LinkerNetworkDataSource {

    suspend fun login(loginToServer: LoginToServer): LoginResponse

    suspend fun getAllProducts(): List<ProductDto>

}