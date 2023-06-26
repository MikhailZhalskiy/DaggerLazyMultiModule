package com.mw.example.feature_detail_impl.di

import androidx.lifecycle.ViewModel
import com.mw.example.feature_detail_impl.DetailViewModel
import com.mw.example.injector.view_model.ViewModelFactoryModule
import com.mw.example.injector.view_model.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module(includes = [ViewModelFactoryModule::class])
interface DetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindsDetailViewModel(detailViewModel: DetailViewModel): ViewModel

}