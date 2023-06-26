package com.mw.example.repository_impl.di

import com.mw.example.injector.ComponentHolder
import com.mw.example.injector.ComponentHolderDelegate
import com.mw.example.repository_api.di.RepositoryApi
import java.lang.ref.WeakReference

object RepositoryComponentHolder : ComponentHolder<RepositoryApi, RepositoryDependencies> {

    private val componentHolderDelegate = ComponentHolderDelegate<
            RepositoryApi,
            RepositoryDependencies,
            RepositoryComponent> { dependencies: RepositoryDependencies ->
        RepositoryComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> RepositoryDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): RepositoryApi = componentHolderDelegate.get()

    internal fun getComponent(): RepositoryComponent = componentHolderDelegate.getComponentImpl()
}