package com.mw.example.daggerlazymultimodule.app.di

import com.mw.example.injector.ComponentHolder
import com.mw.example.injector.ComponentHolderDelegate

object AppComponentHolder : ComponentHolder<AppApi, AppDependencies> {

    private val componentHolderDelegate = ComponentHolderDelegate<
            AppApi,
            AppDependencies,
            AppComponent> { dependencies: AppDependencies ->
        AppComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> AppDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): AppApi = componentHolderDelegate.get()

    internal fun getComponent(): AppComponent = componentHolderDelegate.getComponentImpl()
}