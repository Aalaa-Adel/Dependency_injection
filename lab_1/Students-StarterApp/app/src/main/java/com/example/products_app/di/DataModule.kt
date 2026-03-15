package com.example.products_app.di

import android.app.Application
import androidx.room.Room
import com.example.products_app.app.AppConstants.Companion.BASE_URL
import com.example.products_app.data.local.ProductsDao
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.remote.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideProductService(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application): ProductsDataBase {
        return Room.databaseBuilder(
            application,
            ProductsDataBase::class.java,
            "roomdb"
        ).build()
    }

    @Provides
    fun provideProductsDao(database: ProductsDataBase): ProductsDao {
        return database.getProductsDao()
    }
}