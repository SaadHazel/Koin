package com.saad.learnkoin.Mainrepository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.saad.learnkoin.api.RetrofilProvider
import com.saad.learnkoin.db.DataBaseBuilder
import com.saad.learnkoin.models.Product
import com.saad.learnkoin.models.ProductsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRepository(
    private val context: Context
) {
    val api = RetrofilProvider.productApi
    val db = DataBaseBuilder.getInstance(context)
    val dao = db.AppDao()

    val productsLiveData = MutableLiveData<ProductsEntity>()
    val productsL: LiveData<ProductsEntity>
        get() = productsLiveData

    suspend fun getProductFromApi() {
        api.getProducts()
    }

    fun getProducts(): Flow<ProductsEntity> = flow {
        val result = api.getProducts()

        if (result.body() != null) {
            val productsList = result.body()!!
            emit(productsList)
            dao.insertData(productsList.products)
        }

    }.flowOn(Dispatchers.IO)
}