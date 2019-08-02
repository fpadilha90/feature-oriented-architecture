package com.example.data.di

import com.example.data.repository.FeatureBlueRepositoryImpl
import com.example.feature_blue.domain.repository.FeatureBlueRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DataInject {

    fun modules(): List<Module> = listOf(ApiInject.module(), repositoryModule)

    private val repositoryModule: Module = module {
        single { FeatureBlueRepositoryImpl(get()) as FeatureBlueRepository }
    }
}