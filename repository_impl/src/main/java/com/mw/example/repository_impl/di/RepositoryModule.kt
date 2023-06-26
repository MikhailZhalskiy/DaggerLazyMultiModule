package com.mw.example.repository_impl.di

import com.mw.example.repository_api.Repository
import com.mw.example.repository_impl.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {

    @Binds
    fun bind_RepositoryImpl_to_Repository(repositoryImpl: RepositoryImpl): Repository
}