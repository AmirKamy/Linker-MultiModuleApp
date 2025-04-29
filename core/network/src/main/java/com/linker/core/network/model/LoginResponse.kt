package com.linker.core.network.model

import com.example.linker.core.model.Login
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val token: String
)


fun LoginResponse.asExternalModel(): Login =
    Login(
        token
    )
