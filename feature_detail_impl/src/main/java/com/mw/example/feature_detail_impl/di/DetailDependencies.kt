package com.mw.example.feature_detail_impl.di

import com.mw.example.feature_pdf_api.PdfFeatureStarter
import com.mw.example.injector.BaseDependencies
import com.mw.example.injector_compose.binder.BinderBaseApi
import com.mw.example.repository_api.Repository

interface DetailDependencies : BaseDependencies {
    val repository: Repository
    val binderBaseApi: BinderBaseApi
    val pdfFeatureStarter: PdfFeatureStarter
}