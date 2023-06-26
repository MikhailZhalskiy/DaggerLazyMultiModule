package com.mw.example.feature_list_impl.di

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.mw.example.feature_list_api.di.ListApiFeatureToLifecycle
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [ListModule::class, ListViewModelModule::class],
    dependencies = [ListDependencies::class]
)
@Singleton
internal interface ListComponent : ListApiFeatureToLifecycle {

    val viewModelFactory: ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(dependencies: ListDependencies): ListComponent
    }

    companion object {
        fun initAndGet(dependencies: ListDependencies): ListComponent {
            Log.d("DLMMC", "create ListComponent")
            return DaggerListComponent.factory().create(dependencies)
        }
    }
}