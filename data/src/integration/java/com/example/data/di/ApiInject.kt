package com.example.data.di

import com.example.data.BuildConfig
import com.example.data.api.BlueService
import com.example.data.api.RestApi
import org.koin.core.module.Module
import org.koin.dsl.module

object ApiInject {
    fun module(): Module = module {
        single {
            RestApi().createNetworkClient(BuildConfig.HOST, BuildConfig.DEBUG).create(
                BlueService::class.java
            )
        }
    }
}