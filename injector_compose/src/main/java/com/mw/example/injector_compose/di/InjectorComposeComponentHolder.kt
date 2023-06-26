package com.mw.example.injector_compose.di

import com.mw.example.injector.ComponentHolder
import com.mw.example.injector.ComponentHolderDelegate
import com.mw.example.injector_compose.api.InjectorComposeApi

object InjectorComposeComponentHolder :
    ComponentHolder<InjectorComposeApi, InjectorComposeDependencies> {

    private val componentHolderDelegate = ComponentHolderDelegate<
            InjectorComposeApi,
            InjectorComposeDependencies,
            InjectorComposeComponent> { dependencies: InjectorComposeDependencies ->
        InjectorComposeComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> InjectorComposeDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): InjectorComposeApi = componentHolderDelegate.get()

    internal fun getComponent(): InjectorComposeComponent =
        componentHolderDelegate.getComponentImpl()
}