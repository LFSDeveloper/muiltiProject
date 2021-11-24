package com.carvana.android.mycars.harnessapp

import android.app.Application
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.utils.AppComponentProvider
import com.carvana.android.mycars.di.myCarsCompPublicDi
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

        AppComponentProvider.loadComponent(getKoin(), AppComponent.MyCars)
    }

    private fun startDi() {
        startKoin {
            androidLogger()

            androidContext(this@AppApplication)

            modules(listOf(myCarsCompPublicDi))
        }
    }
}