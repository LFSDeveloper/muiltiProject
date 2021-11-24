package com.carvana.android.myapplication

import android.app.Application
import com.carvana.android.account.di.accountCompPublicDi
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.utils.AppComponentProvider
import com.carvana.android.explore.di.exploreCompPublicDi
import com.carvana.android.myapplication.di.mainAppPublicDi
import com.carvana.android.mycars.di.myCarsCompPublicDi
import com.carvana.android.prequal.di.prequalCompPublicDi
import com.carvana.android.selltrade.di.sellTradeCompPublicDi
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Represents the application class
 */
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // init koin
        startDi()

        // load main app component
        AppComponentProvider.loadComponent(getKoin(), AppComponent.MainApp)
    }

    /**
     * Initiate the koin framework
     */
    private fun startDi() {
        startKoin {
            androidLogger()

            // this will allow app entities to request a context of application type all across
            // without having to expose the application class as a singleton
            androidContext(this@AppApplication)

            // manual upload of app component mandatory modules
            modules(
                listOf(
                    mainAppPublicDi,
                    accountCompPublicDi,
                    exploreCompPublicDi,
                    myCarsCompPublicDi,
                    prequalCompPublicDi,
                    sellTradeCompPublicDi
                )
            )
        }
    }
}