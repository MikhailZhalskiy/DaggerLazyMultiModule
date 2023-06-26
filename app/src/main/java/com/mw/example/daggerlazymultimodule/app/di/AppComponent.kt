package com.mw.example.daggerlazymultimodule.app.di

import android.app.Application
import android.util.Log
import com.mw.example.daggerlazymultimodule.navigation.di.NavigationApi
import dagger.Component

@Component(
    dependencies = [AppDependencies::class]
)
internal interface AppComponent : AppApi {

    val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
    val navigationApi: NavigationApi

    @Component.Factory
    interface Factory {
        fun create(dependencies: AppDependencies): AppComponent
    }

    companion object {
        fun initAndGet(dependencies: AppDependencies): AppComponent {
            Log.d("DLMMC", "create AppComponent")
            return DaggerAppComponent.factory().create(dependencies)
        }
    }
}