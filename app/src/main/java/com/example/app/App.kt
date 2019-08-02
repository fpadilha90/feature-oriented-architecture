package com.example.app

import android.app.Application
import com.example.app.di.AppInject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(AppInject.modules())
        }
    }
}