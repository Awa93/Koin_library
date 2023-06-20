package com.example.koindemo.app

import android.app.Application
import com.example.koindemo.di.module.appModule
import com.example.koindemo.di.module.repoModule
import com.example.koindemo.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp:Application()
{
    override fun onCreate() {
        super.onCreate()
        startKoin() {
            androidContext(this@MainApp)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}