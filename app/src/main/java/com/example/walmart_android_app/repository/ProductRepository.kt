package com.example.walmart_android_app.repository

import com.example.walmart_android_app.model.Product
import android.content.Context
import com.example.walmart_android_app.model.ProductList
import com.google.gson.Gson
class ProductRepository(private val context: Context) {
    fun getProducts(): List<Product> {
        return try {
            val json = context.assets.open("products.json").bufferedReader().use { it.readText() }
            val productList = Gson().fromJson(json, ProductList::class.java)
            productList.products
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}