package com.example.walmart_android_app.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart_android_app.R
import com.example.walmart_android_app.view.ProductAdapter
import com.example.walmart_android_app.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productViewModel.products.observe(this, Observer { products ->
            val adapter = ProductAdapter(products)
            recyclerView.adapter = adapter
        })
    }
}
