package com.example.tsm.responsi

import android.app.Application
import timber.log.Timber

class CarApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
