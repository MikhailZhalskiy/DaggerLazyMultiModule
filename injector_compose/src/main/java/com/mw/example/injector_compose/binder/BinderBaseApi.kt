package com.mw.example.injector_compose.binder

import androidx.lifecycle.LifecycleEventObserver
import com.mw.example.injector.BaseApi

interface BinderBaseApi {
    fun bind(entryId: String, api: BaseApi): LifecycleEventObserver
}