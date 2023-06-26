package com.mw.example.daggerlazymultimodule.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.mw.example.feature_pdf_api.PdfFeatureStarter
import com.mw.example.feature_pdf_impl.di.PdfComponentHolder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PdfFeatureStarterProxy @Inject constructor() : PdfFeatureStarter {

    @Composable
    override fun AddPdfScreen(entry: NavBackStackEntry) {
        PdfComponentHolder.get().pdfFeatureStarter.AddPdfScreen(entry)
    }
}