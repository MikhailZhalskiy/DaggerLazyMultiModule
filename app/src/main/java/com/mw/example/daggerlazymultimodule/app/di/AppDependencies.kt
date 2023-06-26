package com.mw.example.daggerlazymultimodule.app.di

import android.app.Application
import com.mw.example.daggerlazymultimodule.navigation.di.NavigationApi
import com.mw.example.injector.BaseDependencies
import com.mw.example.repository_api.Repository

interface AppDependencies : BaseDependencies {
    val repository: Repository
    val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
    val navigationApi: NavigationApi
}