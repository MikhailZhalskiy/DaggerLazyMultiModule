package com.mw.example.repository_impl.di

import android.util.Log
import com.mw.example.repository_api.di.RepositoryApi
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [RepositoryModule::class],
    dependencies = [RepositoryDependencies::class]
)
@Singleton
internal interface RepositoryComponent : RepositoryApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: RepositoryDependencies): RepositoryComponent
    }

    companion object {
        fun initAndGet(dependencies: RepositoryDependencies): RepositoryComponent {
            Log.d("DLMMC", "create RepositoryComponent")
            return DaggerRepositoryComponent.factory().create(dependencies)
        }
    }
}