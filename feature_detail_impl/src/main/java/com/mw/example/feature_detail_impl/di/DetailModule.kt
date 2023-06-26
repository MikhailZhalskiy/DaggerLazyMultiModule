package com.mw.example.feature_detail_impl.di

import com.mw.example.feature_detail_api.di.DetailFeatureStarter
import com.mw.example.feature_detail_impl.navigation.DetailFeatureStarterImpl
import dagger.Binds
import dagger.Module

@Module
internal interface DetailModule {

    @Binds
    fun bind_FeatureStarterImpl_DetailFeatureStarter(featureStarterImpl: DetailFeatureStarterImpl): DetailFeatureStarter
}