package com.mw.example.feature_pdf_impl

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class PdfViewModel @Inject constructor() : ViewModel() {

    init {
        Log.d("DLMMC", "ListViewModel::init()")
    }

    fun openPdf(): String = "PDF Viewer"
}