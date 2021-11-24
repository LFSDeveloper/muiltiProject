package com.carvana.android.myapplication.di

import com.carvana.android.common.bases.AppDelegate
import com.carvana.android.myapplication.publicIn.AppDelegateImpl
import org.koin.dsl.module

val mainAppModule = module {
    single<AppDelegate> { AppDelegateImpl(getKoin(), get()) }
}