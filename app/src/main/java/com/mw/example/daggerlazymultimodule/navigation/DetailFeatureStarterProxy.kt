package com.mw.example.daggerlazymultimodule.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.mw.example.feature_detail_api.di.DetailFeatureStarter
import com.mw.example.feature_detail_impl.di.DetailComponentHolder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailFeatureStarterProxy @Inject constructor() : DetailFeatureStarter {

    @Composable
    override fun AddDetailFlowScreen(entry: NavBackStackEntry) {
        DetailComponentHolder.get().detailFeatureStarter.AddDetailFlowScreen(entry)
    }
}