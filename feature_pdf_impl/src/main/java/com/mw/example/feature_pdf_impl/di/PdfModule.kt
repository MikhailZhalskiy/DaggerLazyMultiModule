package com.mw.example.feature_pdf_impl.di

import com.mw.example.feature_pdf_api.PdfFeatureStarter
import com.mw.example.feature_pdf_impl.navigation.PdfFeatureStarterImpl
import dagger.Binds
import dagger.Module

@Module
interface PdfModule {

    @Binds
    fun bind_PdfFeatureStarterImpl_PdfFeatureStarter(featureStarterImpl: PdfFeatureStarterImpl): PdfFeatureStarter
}
