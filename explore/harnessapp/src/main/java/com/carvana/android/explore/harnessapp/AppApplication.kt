package com.carvana.android.explore.harnessapp

import android.app.Application
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.utils.AppComponentProvider
import com.carvana.android.explore.di.exploreCompPublicDi
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Implements the Account Harness App application class
 */
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startDi()

        AppComponentProvider.loadComponent(getKoin(), AppComponent.Explore)
    }

    private fun startDi() {
        startKoin {
            androidLogger()

            androidContext(this@AppApplication)

            modules(listOf(exploreCompPublicDi))
        }
    }
}