package com.mw.example.feature_pdf_impl.di

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.mw.example.feature_pdf_api.PdfApiFeatureToLifecycle
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [PdfModule::class, PdfViewModelModule::class],
    dependencies = [PdfDependencies::class]
)
@Singleton
internal interface PdfComponent : PdfApiFeatureToLifecycle {

    val viewModelFactory: ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(dependencies: PdfDependencies): PdfComponent
    }

    companion object {
        fun initAndGet(dependencies: PdfDependencies): PdfComponent {
            Log.d("DLMMC", "create PdfComponent")
            return DaggerPdfComponent.factory().create(dependencies)
        }
    }
}