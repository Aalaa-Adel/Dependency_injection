package com.example.products_app.fav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.products_app.app.AppEntyPoint
import org.koin.androidx.compose.koinViewModel

class FavProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {

            val viewModel = koinViewModel<FavProductsViewModel>()

            FavProductsScreen(viewModel)
        }
    }
}

