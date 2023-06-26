package com.mw.example.feature_pdf_api

import com.mw.example.injector.BaseApi
import com.mw.example.injector_compose.binder.BinderBaseApiToLifecycle

interface PdfApiFeatureToLifecycle : BaseApi, BinderBaseApiToLifecycle {
    val pdfFeatureStarter: PdfFeatureStarter
}