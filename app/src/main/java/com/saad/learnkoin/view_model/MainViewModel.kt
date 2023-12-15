package com.saad.learnkoin.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saad.learnkoin.Mainrepository.MainRepository
import com.saad.learnkoin.models.Product
import com.saad.learnkoin.models.ProductsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MainRepository
):ViewModel() {

    init {

        viewModelScope.launch {
            repository.getProducts().collect { productList ->
                repository.productsLiveData.postValue(productList)
            }
        }
    }

    val productsData: LiveData<ProductsEntity>
        get() = repository.productsL
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products


    fun addProductInDb(data:Product){
        viewModelScope.launch {
            repository.addProductInDb(data)
        }
    }

}