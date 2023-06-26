package com.mw.example.feature_detail_impl.di

import com.mw.example.feature_detail_api.di.DetailApiFeatureToLifecycle
import com.mw.example.injector.ComponentHolder
import com.mw.example.injector.ComponentHolderDelegate

object DetailComponentHolder : ComponentHolder<DetailApiFeatureToLifecycle, DetailDependencies> {

    private val componentHolderDelegate = ComponentHolderDelegate<
            DetailApiFeatureToLifecycle,
            DetailDependencies,
            DetailComponent> { dependencies: DetailDependencies ->
        DetailComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> DetailDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): DetailApiFeatureToLifecycle = componentHolderDelegate.get()

    internal fun getComponent(): DetailComponent = componentHolderDelegate.getComponentImpl()
}