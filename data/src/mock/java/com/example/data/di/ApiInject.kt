package com.example.data.di

import com.example.data.api.BlueService
import com.example.data.api.BlueServiceMock
import org.koin.core.module.Module
import org.koin.dsl.module

object ApiInject {

    fun module(): Module = module {
        single { BlueServiceMock() as BlueService }
    }
}