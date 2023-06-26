package com.mw.example.feature_pdf_api

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

interface PdfFeatureStarter {

    @Composable
    fun AddPdfScreen(entry: NavBackStackEntry)
}