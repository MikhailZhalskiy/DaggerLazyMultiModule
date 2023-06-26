package com.mw.example.feature_pdf_impl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.mw.example.feature_pdf_api.PdfFeatureStarter
import com.mw.example.feature_pdf_impl.PdfScreen
import com.mw.example.feature_pdf_impl.PdfViewModel
import com.mw.example.feature_pdf_impl.di.PdfComponent
import com.mw.example.feature_pdf_impl.di.PdfComponentHolder
import com.mw.example.injector_compose.binder.BindApiToEntryLifecycle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PdfFeatureStarterImpl @Inject constructor() : PdfFeatureStarter {

    @Composable
    override fun AddPdfScreen(entry: NavBackStackEntry) {
        BindApiToEntryLifecycle(
            entry = entry,
            ch = PdfComponentHolder
        ) {
            val component: PdfComponent = remember { PdfComponentHolder.getComponent() }
            // Inject(factory = component.viewModelFactory()) { }
            val viewModel: PdfViewModel = viewModel(factory = component.viewModelFactory)
            PdfScreen(viewModel)
        }
    }
}
