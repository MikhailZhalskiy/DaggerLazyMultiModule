package com.mw.example.daggerlazymultimodule.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mw.example.daggerlazymultimodule.app.di.AppApi
import com.mw.example.daggerlazymultimodule.app.di.AppComponent
import com.mw.example.daggerlazymultimodule.app.di.AppComponentHolder
import com.mw.example.daggerlazymultimodule.ui.theme.DaggerLazyMultiModuleTheme
import com.mw.example.feature_detail_impl.di.DetailComponentHolder
import com.mw.example.feature_list_impl.di.ListComponentHolder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerLazyMultiModuleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNav()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNav() {
    val navController = rememberNavController()
    val component: AppComponent = remember { AppComponentHolder.getComponent() }

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = "list",
            modifier = Modifier.padding(it)
        ) {

            composable(route = "list") { entry ->
                component.navigationApi.listFeatureStarter.AddListScreen(entry) {
                    navController.navigate("detail")
                }
            }

            composable(route = "detail") { entry ->
                component.navigationApi.detailFeatureStarter.AddDetailFlowScreen(entry)
            }
        }
    }
}