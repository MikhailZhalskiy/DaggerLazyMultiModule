package com.mw.example.feature_detail_impl.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.mw.example.feature_detail_api.di.DetailFeatureStarter
import com.mw.example.feature_detail_impl.DetailFlowScreen
import com.mw.example.feature_detail_impl.di.DetailComponentHolder
import com.mw.example.injector_compose.binder.BindApiToEntryLifecycle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DetailFeatureStarterImpl @Inject constructor() : DetailFeatureStarter {

    @Composable
    override fun AddDetailFlowScreen(entry: NavBackStackEntry) {
        BindApiToEntryLifecycle(
            entry = entry,
            ch = DetailComponentHolder
        ) {
            // Inject(factory = component.viewModelFactory()) { }
            DetailFlowScreen()
        }
    }
}
