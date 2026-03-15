package com.example.products_app.fav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.products_app.app.AppEntyPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {

            val viewModel = hiltViewModel<FavProductsViewModel>()

            FavProductsScreen(viewModel)
        }
    }
}

