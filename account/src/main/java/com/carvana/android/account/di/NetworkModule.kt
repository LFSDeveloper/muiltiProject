package com.carvana.android.account.di

import com.carvana.android.account.utils.AccountNetworkImpl
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.utils.NetworkSpec
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val accountNetworkModule = module {
    /**
     * Mark an implementation of [NetworkSpec] with the component name from which is produced
     */
    factory<NetworkSpec>(qualifier = named(AppComponent.Account)) {
        AccountNetworkImpl(androidContext())
    }
}