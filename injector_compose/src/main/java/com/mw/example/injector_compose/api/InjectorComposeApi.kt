package com.mw.example.injector_compose.api

import android.app.Application
import com.mw.example.injector.BaseApi
import com.mw.example.injector_compose.binder.BinderBaseApi

interface InjectorComposeApi : BaseApi {
    val binderBaseApi: BinderBaseApi
    val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
}