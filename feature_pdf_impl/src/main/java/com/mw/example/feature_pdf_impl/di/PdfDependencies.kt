package com.mw.example.feature_pdf_impl.di

import com.mw.example.injector.BaseDependencies
import com.mw.example.injector_compose.binder.BinderBaseApi

interface PdfDependencies : BaseDependencies {
    val binderBaseApi: BinderBaseApi
}
