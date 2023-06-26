package com.mw.example.feature_pdf_impl.di

import com.mw.example.feature_pdf_api.PdfApiFeatureToLifecycle
import com.mw.example.injector.ComponentHolder
import com.mw.example.injector.ComponentHolderDelegate

object PdfComponentHolder : ComponentHolder<PdfApiFeatureToLifecycle, PdfDependencies> {

    private val componentHolderDelegate = ComponentHolderDelegate<
            PdfApiFeatureToLifecycle,
            PdfDependencies,
            PdfComponent> { dependencies: PdfDependencies ->
        PdfComponent.initAndGet(dependencies)
    }

    override var dependencyProvider: (() -> PdfDependencies)? by componentHolderDelegate::dependencyProvider

    override fun get(): PdfApiFeatureToLifecycle = componentHolderDelegate.get()

    internal fun getComponent(): PdfComponent = componentHolderDelegate.getComponentImpl()
}