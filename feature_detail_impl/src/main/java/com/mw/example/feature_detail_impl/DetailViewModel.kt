package com.mw.example.feature_detail_impl

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mw.example.repository_api.Repository
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    init {
        Log.d("DLMMC", "DetailViewModel::init()")
    }

    fun getDetail(): String = repository.getDetail("777")
}