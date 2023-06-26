package com.mw.example.repository_api.di

import com.mw.example.injector.BaseApi
import com.mw.example.repository_api.Repository

interface RepositoryApi : BaseApi {
    val repository: Repository
}