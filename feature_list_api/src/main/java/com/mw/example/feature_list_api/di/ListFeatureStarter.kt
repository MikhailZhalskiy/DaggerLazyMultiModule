package com.mw.example.feature_list_api.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

interface ListFeatureStarter {

    @Composable
    fun AddListScreen(entry: NavBackStackEntry, moveDetailScreen: () -> Unit)
}