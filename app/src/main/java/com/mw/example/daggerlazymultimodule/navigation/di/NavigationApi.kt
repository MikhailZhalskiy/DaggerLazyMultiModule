package com.mw.example.daggerlazymultimodule.navigation.di

import com.mw.example.feature_detail_api.di.DetailFeatureStarter
import com.mw.example.feature_list_api.di.ListFeatureStarter
import com.mw.example.feature_pdf_api.PdfFeatureStarter
import com.mw.example.injector.BaseApi

interface NavigationApi : BaseApi {
    val listFeatureStarter: ListFeatureStarter
    val detailFeatureStarter: DetailFeatureStarter
    val pdfFeatureStarter: PdfFeatureStarter
}
