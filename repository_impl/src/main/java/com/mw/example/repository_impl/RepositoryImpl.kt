package com.mw.example.repository_impl

import com.mw.example.repository_api.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RepositoryImpl @Inject constructor() : Repository {

    override fun getList(): List<String> {
        return listOf(
            "1", "2", "3", "4", "5", "6", "7", "8", "9"
        )
    }

    override fun getDetail(id: String): String {
        return "detail $id"
    }
}