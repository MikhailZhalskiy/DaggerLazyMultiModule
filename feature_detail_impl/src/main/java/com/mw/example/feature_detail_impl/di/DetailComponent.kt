package com.mw.example.feature_detail_impl.di

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.mw.example.feature_detail_api.di.DetailApiFeatureToLifecycle
import com.mw.example.feature_pdf_api.PdfFeatureStarter
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [DetailDependencies::class],
    modules = [DetailModule::class, DetailViewModelModule::class]
)
@Singleton
internal interface DetailComponent : DetailApiFeatureToLifecycle {

    val viewModelFactory: ViewModelProvider.Factory
    val pdfFeatureStarter: PdfFeatureStarter

    @Component.Factory
    interface Factory {
        fun create(dependencies: DetailDependencies): DetailComponent
    }

    companion object {
        fun initAndGet(dependencies: DetailDependencies): DetailComponent {
            Log.d("DLMMC", "create DetailComponent")
            return DaggerDetailComponent.factory().create(dependencies)
        }
    }
}