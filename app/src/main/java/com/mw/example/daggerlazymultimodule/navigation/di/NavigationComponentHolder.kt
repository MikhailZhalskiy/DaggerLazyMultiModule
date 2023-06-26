package com.mw.example.daggerlazymultimodule.navigation.di

import com.mw.example.injector.ComponentHolder
import com.mw.example.injector.ComponentHolderDelegate

object NavigationComponentHolder : ComponentHolder<NavigationApi, NavigationDependencies> {

    private val componentHolderDelegate = ComponentHolderDelegate<
            NavigationApi,
            NavigationDependencies,
            NavigationComponent> { dependencies: NavigationDependencies ->
        NavigationComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> NavigationDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): NavigationApi = componentHolderDelegate.get()

    internal fun getComponent(): NavigationComponent = componentHolderDelegate.getComponentImpl()
}