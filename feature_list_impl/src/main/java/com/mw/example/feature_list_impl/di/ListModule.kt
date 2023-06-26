package com.mw.example.feature_list_impl.di

import com.mw.example.feature_list_api.di.ListFeatureStarter
import com.mw.example.feature_list_impl.navigation.ListFeatureStarterImpl
import dagger.Binds
import dagger.Module

@Module
interface ListModule {

    @Binds
    fun bind_FeatureStarterImpl_ListFeatureStarter(featureStarterImpl: ListFeatureStarterImpl): ListFeatureStarter
}
