package com.example.retrofit_koin_mvvm

import android.app.Application
import com.example.retrofit_koin_mvvm.di.appModule
import com.example.retrofit_koin_mvvm.di.repositoryModule
import com.example.retrofit_koin_mvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(viewModelModule, repositoryModule, appModule))
        }
    }
}