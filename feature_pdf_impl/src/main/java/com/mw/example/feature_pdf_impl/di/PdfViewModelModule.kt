package com.mw.example.feature_pdf_impl.di

import androidx.lifecycle.ViewModel
import com.mw.example.feature_pdf_impl.PdfViewModel
import com.mw.example.injector.view_model.ViewModelFactoryModule
import com.mw.example.injector.view_model.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
interface PdfViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PdfViewModel::class)
    fun bindsPdfViewModel(pdfViewModel: PdfViewModel): ViewModel

}