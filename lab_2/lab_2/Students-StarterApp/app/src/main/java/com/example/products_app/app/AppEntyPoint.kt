package com.example.products_app.app

import android.app.Application
import com.example.products_app.di.AppContainer
import com.example.products_app.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AppEntyPoint : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppEntyPoint)
            modules(dataModule)
        }
    }
}