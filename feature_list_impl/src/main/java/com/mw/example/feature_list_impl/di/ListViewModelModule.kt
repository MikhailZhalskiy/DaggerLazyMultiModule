package com.mw.example.feature_list_impl.di

import androidx.lifecycle.ViewModel
import com.mw.example.feature_list_impl.ListViewModel
import com.mw.example.injector.view_model.ViewModelFactoryModule
import com.mw.example.injector.view_model.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface ListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun bindsListViewModel(listViewModel: ListViewModel): ViewModel

}