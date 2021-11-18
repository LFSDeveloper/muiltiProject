package com.carvana.android.myapplication

import android.app.Application
import com.carvana.android.account.di.accountCompPublicDi
import com.carvana.android.common.utils.AppComponentProvider
import com.carvana.android.explore.di.exploreCompPublicDi
import com.carvana.android.myapplication.di.environmentModule
import com.carvana.android.myapplication.di.mainAppModule
import com.carvana.android.myapplication.di.networkModule
import com.carvana.android.myapplication.di.viewModelModule
import com.carvana.android.mycars.di.myCarsCompPublicDi
import com.carvana.android.prequal.di.prequalCompPublicDi
import com.carvana.android.selltrade.di.sellTradeCompPublicDi
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 * Represents the application class
 */
class AppApplication : Application() {

    private val appModules: List<Module>
        get() = listOf(viewModelModule, mainAppModule, environmentModule, networkModule)

    override fun onCreate() {
        super.onCreate()

        // init koin
        startDi()

        // inflate app di modules
        getKoin().loadModules(appModules)

        // load main entry components
        AppComponentProvider.inflateMainEntries(getKoin())
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