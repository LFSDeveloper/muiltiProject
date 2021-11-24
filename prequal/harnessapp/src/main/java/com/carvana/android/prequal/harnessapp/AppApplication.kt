package com.carvana.android.prequal.harnessapp

import android.app.Application
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.utils.AppComponentProvider
import com.carvana.android.prequal.di.prequalCompPublicDi
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

        AppComponentProvider.loadComponent(getKoin(), AppComponent.Prequal)
    }

    private fun startDi() {
        startKoin {
            androidLogger()

            androidContext(this@AppApplication)

            modules(listOf(prequalCompPublicDi))
        }
    }
}