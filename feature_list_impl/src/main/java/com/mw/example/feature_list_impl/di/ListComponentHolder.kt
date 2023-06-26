package com.mw.example.feature_list_impl.di

import com.mw.example.feature_list_api.di.ListApiFeatureToLifecycle
import com.mw.example.injector.ComponentHolder
import com.mw.example.injector.ComponentHolderDelegate

object ListComponentHolder : ComponentHolder<ListApiFeatureToLifecycle, ListDependencies> {

    private val componentHolderDelegate = ComponentHolderDelegate<
            ListApiFeatureToLifecycle,
            ListDependencies,
            ListComponent> { dependencies: ListDependencies ->
        ListComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> ListDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): ListApiFeatureToLifecycle = componentHolderDelegate.get()

    internal fun getComponent(): ListComponent = componentHolderDelegate.getComponentImpl()
}