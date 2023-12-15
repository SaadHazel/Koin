package com.saad.learnkoin.api

import com.saad.learnkoin.models.Product
import com.saad.learnkoin.models.ProductsEntity
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("/products")
    suspend fun getProducts(): Response<ProductsEntity>
}