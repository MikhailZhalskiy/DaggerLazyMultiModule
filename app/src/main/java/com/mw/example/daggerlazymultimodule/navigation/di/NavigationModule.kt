package com.mw.example.daggerlazymultimodule.navigation.di

import com.mw.example.daggerlazymultimodule.navigation.DetailFeatureStarterProxy
import com.mw.example.daggerlazymultimodule.navigation.ListFeatureStarterProxy
import com.mw.example.daggerlazymultimodule.navigation.PdfFeatureStarterProxy
import com.mw.example.feature_detail_api.di.DetailFeatureStarter
import com.mw.example.feature_list_api.di.ListFeatureStarter
import com.mw.example.feature_pdf_api.PdfFeatureStarter
import dagger.Binds
import dagger.Module

@Module
internal interface NavigationModule {

    @Binds
    fun bind_ListFeatureStarterProxy_ListFeatureStarter(featureStarterProxy: ListFeatureStarterProxy): ListFeatureStarter

    @Binds
    fun bind_DetailFeatureStarterProxy_DetailFeatureStarter(featureStarterProxy: DetailFeatureStarterProxy): DetailFeatureStarter

    @Binds
    fun bind_PdfFeatureStarterProxy_PdfFeatureStarter(featureStarterProxy: PdfFeatureStarterProxy): PdfFeatureStarter
}