package com.mw.example.feature_detail_impl

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mw.example.feature_detail_impl.di.DetailComponent
import com.mw.example.feature_detail_impl.di.DetailComponentHolder
import com.mw.example.injector_compose.binder.BindApiToEntryLifecycle

@Composable
fun DetailFlowScreen() {
    DetailFlowNav()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailFlowNav() {
    val navController = rememberNavController()
    val component: DetailComponent = remember { DetailComponentHolder.getComponent() }

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = "detail",
            modifier = Modifier.padding(it)
        ) {

            composable(route = "detail") { entry ->
                BindApiToEntryLifecycle(entry = entry, ch = DetailComponentHolder) {
                    val viewModel: DetailViewModel = viewModel(factory = component.viewModelFactory)
                    DetailScreen(viewModel) {
                        navController.navigate("pdf")
                    }
                }
            }

            composable(route = "pdf") { entry ->
                component.pdfFeatureStarter.AddPdfScreen(entry = entry)
            }
        }
    }
}