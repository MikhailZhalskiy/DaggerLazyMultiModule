package com.mw.example.injector_compose.di

import android.app.Application
import com.mw.example.injector_compose.binder.BinderBaseApi
import com.mw.example.injector_compose.binder.BinderBaseApiImpl
import dagger.Binds
import dagger.Module

@Module
interface InjectorComposeModule {

    @Binds
    fun bind_BinderApiToEntryLifecycleImpl_BinderApiToEntryLifecycle(
        binderApiToEntryLifecycleImpl: BinderBaseApiImpl
    ): BinderBaseApi

    @Binds
    fun bind_BinderApiToEntryLifecycleImpl_ActivityLifecycleCallbacks(
        binderApiToEntryLifecycleImpl: BinderBaseApiImpl
    ): Application.ActivityLifecycleCallbacks
}