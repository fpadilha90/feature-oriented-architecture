package com.example.feature_blue.di

import com.example.feature_blue.domain.interactor.PaintInBlue
import com.example.feature_blue.ui.feature_blue.BlueViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object BlueInject {
    fun modules(): List<Module> = listOf(viewModelModule, useCaseModule)

    private val viewModelModule: Module = module {
        viewModel { BlueViewModel(get()) }
    }
    private val useCaseModule: Module = module {
        factory { PaintInBlue(get()) }
    }
}