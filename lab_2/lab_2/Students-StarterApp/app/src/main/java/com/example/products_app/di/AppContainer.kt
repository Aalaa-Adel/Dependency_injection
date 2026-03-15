package com.example.products_app.di

import android.app.Application
import androidx.room.Room
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.app.AppConstants.Companion.BASE_URL
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductService
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AppContainer(application: Application) {
    private val productService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductService::class.java)
    }

    private val productsDataBase by lazy {
        Room.databaseBuilder(
            application,
            ProductsDataBase::class.java,
            "roomdb"
        ).build()
    }

    private val productsDao by lazy { productsDataBase.getProductsDao() }
    private val productsRemoteDataSource by lazy { ProductsRemoteDataSourceImpl(productService) }
    private val productsLocalDataSource by lazy { ProductsLocalDataSource(productsDao) }

    val productsRepository by lazy {
        ProductsRepositoryImpl(
            remoteDataSource = productsRemoteDataSource,
            localDataSource = productsLocalDataSource
        )
    }
}