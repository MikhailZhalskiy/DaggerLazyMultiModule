package com.mw.example.daggerlazymultimodule.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.mw.example.feature_list_api.di.ListFeatureStarter
import com.mw.example.feature_list_impl.di.ListComponentHolder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListFeatureStarterProxy @Inject constructor() : ListFeatureStarter {

    @Composable
    override fun AddListScreen(entry: NavBackStackEntry, moveDetailScreen: () -> Unit) {
        ListComponentHolder.get().listFeatureStarter.AddListScreen(entry, moveDetailScreen)
    }
}