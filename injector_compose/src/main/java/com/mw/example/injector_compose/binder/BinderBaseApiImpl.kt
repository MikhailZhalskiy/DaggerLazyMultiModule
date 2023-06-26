package com.mw.example.injector_compose.binder

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.mw.example.injector.BaseApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BinderBaseApiImpl @Inject constructor() : BinderBaseApi,
    Application.ActivityLifecycleCallbacks {

    private val entryLifecycleEventObservers = mutableMapOf<String, EntryLifecycleEventObserver>()

    private var isCanBeRemoved = true

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {}

    override fun onActivityStarted(p0: Activity) {}

    override fun onActivityResumed(p0: Activity) {}

    override fun onActivityPaused(p0: Activity) {}

    override fun onActivityStopped(p0: Activity) {}

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}

    override fun onActivityPreDestroyed(activity: Activity) {
        if (activity.isChangingConfigurations) {
            isCanBeRemoved = false
        }
        Log.d(
            "DLMMC",
            "$activity::onActivityPreDestroyed() isChangingConfigurations = ${activity.isChangingConfigurations}"
        )
    }

    override fun onActivityDestroyed(p0: Activity) {
        isCanBeRemoved = true
        Log.d("DLMMC", "$p0::onActivityDestroyed()")
    }

    override fun bind(entryId: String, api: BaseApi): LifecycleEventObserver {
        return entryLifecycleEventObservers.getOrPut(entryId) {
            EntryLifecycleEventObserver(entryId, api, ::removeEntryLifecycleEventObserver)
        }
    }

    private fun removeEntryLifecycleEventObserver(entryId: String) {
        if (isCanBeRemoved) {
            Log.d("DLMMC", "removed entryId = $entryId")
            entryLifecycleEventObservers.remove(entryId)
        }
    }


    private class EntryLifecycleEventObserver(
        private val entryId: String,
        private val api: BaseApi,
        private val removedObserver: (entryId: String) -> Unit
    ) : LifecycleEventObserver {

        init {
            Log.d("DLMMC", "LifecycleEventObserver::init($entryId) $this")
        }

        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                Log.d("DLMMC", "entryId = $entryId -> event = $event")
                removedObserver(entryId)
            }
        }
    }
}