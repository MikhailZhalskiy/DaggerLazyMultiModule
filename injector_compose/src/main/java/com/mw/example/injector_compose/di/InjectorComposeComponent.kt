package com.mw.example.injector_compose.di

import android.util.Log
import com.mw.example.injector_compose.api.InjectorComposeApi
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [InjectorComposeDependencies::class],
    modules = [InjectorComposeModule::class]
)
@Singleton
interface InjectorComposeComponent : InjectorComposeApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: InjectorComposeDependencies): InjectorComposeComponent
    }

    companion object {
        fun initAndGet(dependencies: InjectorComposeDependencies): InjectorComposeComponent {
            Log.d("DLMMC", "create InjectorComposeComponent")
            return DaggerInjectorComposeComponent.factory().create(dependencies)
        }
    }
}