package com.sena.crud.domain.repository

import com.sena.crud.domain.model.ProductModel

interface ProductRepository {
    suspend fun GetProductById(
        id: Int
    ): ProductModel

    suspend fun UpdateProduct(
        id: Int,
        product: ProductModel
    ): ProductModel
}