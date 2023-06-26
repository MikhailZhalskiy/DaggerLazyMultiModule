package com.mw.example.feature_list_impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mw.example.feature_list_impl.di.ListComponentHolder

@Composable
fun ListScreen(
    viewModel: ListViewModel,
    moveDetailScreen: () -> Unit = {}
) {
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "SCREEN_LIST",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = moveDetailScreen,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "moveDetailScreen")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = viewModel.listPerson(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}