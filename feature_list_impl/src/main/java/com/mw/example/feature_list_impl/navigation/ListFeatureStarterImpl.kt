package com.mw.example.feature_list_impl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.mw.example.feature_list_api.di.ListFeatureStarter
import com.mw.example.feature_list_impl.ListScreen
import com.mw.example.feature_list_impl.ListViewModel
import com.mw.example.feature_list_impl.di.ListComponent
import com.mw.example.feature_list_impl.di.ListComponentHolder
import com.mw.example.injector_compose.binder.BindApiToEntryLifecycle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListFeatureStarterImpl @Inject constructor() : ListFeatureStarter {

    @Composable
    override fun AddListScreen(entry: NavBackStackEntry, moveDetailScreen: () -> Unit) {
        BindApiToEntryLifecycle(
            entry = entry,
            ch = ListComponentHolder
        ) {
            val component: ListComponent = remember { ListComponentHolder.getComponent() }
            // Inject(factory = component.viewModelFactory()) { }
            val viewModel: ListViewModel = viewModel(factory = component.viewModelFactory)
            ListScreen(viewModel, moveDetailScreen)
        }
    }
}
