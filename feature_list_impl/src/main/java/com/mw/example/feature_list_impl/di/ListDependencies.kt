package com.mw.example.feature_list_impl.di

import com.mw.example.injector.BaseDependencies
import com.mw.example.injector_compose.binder.BinderBaseApi
import com.mw.example.repository_api.Repository

interface ListDependencies : BaseDependencies {
    val repository: Repository
    val binderBaseApi: BinderBaseApi
}
