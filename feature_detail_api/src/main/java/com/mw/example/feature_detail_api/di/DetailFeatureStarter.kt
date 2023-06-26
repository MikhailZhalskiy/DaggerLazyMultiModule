package com.mw.example.feature_detail_api.di

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

interface DetailFeatureStarter {

    @Composable
    fun AddDetailFlowScreen(entry: NavBackStackEntry)
}