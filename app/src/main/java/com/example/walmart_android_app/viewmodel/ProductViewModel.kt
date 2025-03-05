package com.example.walmart_android_app.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.walmart_android_app.model.Product
import com.example.walmart_android_app.repository.ProductRepository

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProductRepository(application)
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        loadProducts()
    }

    private fun loadProducts() {
        _products.value = repository.getProducts()
    }
}