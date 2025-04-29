package com.linker.core.network.model

import com.example.linker.core.model.Login
import com.example.linker.core.model.Product
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
)


fun ProductDto.asExternalModel(): Product =
    Product(
        id = id,
        title = title,
        price = price,
        description = description,
        category = category,
        image = image
    )
