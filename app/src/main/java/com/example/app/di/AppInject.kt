package com.example.app.di

import com.example.data.di.DataInject
import com.example.feature_blue.di.BlueInject
import org.koin.core.module.Module

object AppInject {

    fun modules(): List<Module> =
        ArrayList<Module>().apply {
            addAll(DataInject.modules())
            addAll(BlueInject.modules())
        }
}