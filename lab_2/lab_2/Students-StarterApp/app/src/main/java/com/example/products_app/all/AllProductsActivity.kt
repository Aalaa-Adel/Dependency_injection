package com.example.products_app.all

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.products_app.app.AppEntyPoint
import org.koin.androidx.compose.koinViewModel


class AllProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel = koinViewModel<AllProductsViewModel>()

            AllProductsScreen(viewModel)
        }
    }
}
