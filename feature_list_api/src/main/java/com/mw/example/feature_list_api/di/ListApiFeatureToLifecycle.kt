package com.mw.example.feature_list_api.di

import com.mw.example.injector.BaseApi
import com.mw.example.injector_compose.binder.BinderBaseApiToLifecycle

interface ListApiFeatureToLifecycle : BaseApi, BinderBaseApiToLifecycle {
    val listFeatureStarter: ListFeatureStarter
}
