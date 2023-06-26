package com.mw.example.injector.view_model

import androidx.lifecycle.ViewModelProvider
import com.mw.example.injector.view_model.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}