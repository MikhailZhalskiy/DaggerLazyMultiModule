package com.mw.example.injector_compose.binder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import com.mw.example.injector.BaseApi
import com.mw.example.injector.BaseDependencies
import com.mw.example.injector.ComponentHolder

@Composable
inline fun <reified CH : ComponentHolder<out BaseApi, out BaseDependencies>> BindApiToEntryLifecycle(
    entry: NavBackStackEntry,
    ch: CH,
    content: @Composable () -> Unit
) {
    val api = remember { ch.get() }
    checkNotNull(api as? BinderBaseApiToLifecycle) {
        ClassCastException("$api in not implement BinderBaseApiToLifecycle")
    }.run {
        val lifecycleEventObserver = remember {
            binderBaseApi.bind(entry.id, api)
        }
        entry.lifecycle.addObserver(lifecycleEventObserver)
        content()
    }
}