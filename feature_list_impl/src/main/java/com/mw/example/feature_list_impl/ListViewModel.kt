package com.mw.example.feature_list_impl

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mw.example.repository_api.Repository
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    init {
        Log.d("DLMMC", "ListViewModel::init()")
    }

    fun listPerson(): String = repository.getList().toString()
}