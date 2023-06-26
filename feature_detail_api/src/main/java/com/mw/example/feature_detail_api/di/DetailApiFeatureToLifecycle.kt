package com.mw.example.feature_detail_api.di

import com.mw.example.injector.BaseApi
import com.mw.example.injector_compose.binder.BinderBaseApiToLifecycle

interface DetailApiFeatureToLifecycle : BaseApi, BinderBaseApiToLifecycle {
    val detailFeatureStarter: DetailFeatureStarter
}