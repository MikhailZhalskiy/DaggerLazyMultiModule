package com.mw.example.repository_api

interface Repository {
    fun getList(): List<String>
    fun getDetail(id: String): String
}