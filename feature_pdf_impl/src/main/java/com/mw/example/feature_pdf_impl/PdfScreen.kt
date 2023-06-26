package com.mw.example.feature_pdf_impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PdfScreen(
    viewModel: PdfViewModel,
) {
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "SCREEN_PDF",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = viewModel.openPdf(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}