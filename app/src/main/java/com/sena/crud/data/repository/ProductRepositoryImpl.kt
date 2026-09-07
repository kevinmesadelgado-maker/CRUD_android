package com.sena.crud.data.repository

import com.sena.crud.data.mapper.toDomain
import com.sena.crud.data.mapper.toRequest
import com.sena.crud.data.remote.api.ProductApiService
import com.sena.crud.domain.model.ProductModel
import com.sena.crud.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApiService
): ProductRepository {
    override suspend fun GetProductById(id: Int): ProductModel {
        val response = api.GetProductByid(id)
        return response.toDomain()
    }

    override suspend fun UpdateProduct(id: Int, product: ProductModel): ProductModel {
        val response = api.UpdateProduct(id, product.toRequest())
        return response.toDomain()
    }
}