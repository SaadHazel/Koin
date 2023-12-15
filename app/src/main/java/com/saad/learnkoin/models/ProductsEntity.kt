package com.saad.learnkoin.models

data class ProductsEntity(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)