package com.mw.example.daggerlazymultimodule.app

import android.app.Application
import com.mw.example.daggerlazymultimodule.app.di.AppComponentHolder
import com.mw.example.daggerlazymultimodule.app.di.InitDi

class App : Application() {

    private val appComponent by lazy {
        AppComponentHolder.getComponent()
    }

    override fun onCreate() {
        super.onCreate()
        InitDi.init()
        registerActivityLifecycleCallbacks(appComponent.activityLifecycleCallbacks)
    }
}