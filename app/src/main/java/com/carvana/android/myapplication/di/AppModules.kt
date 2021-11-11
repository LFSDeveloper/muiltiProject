package com.carvana.android.myapplication.di

import com.carvana.android.common.bases.AppDelegate
import com.carvana.android.myapplication.appDelegate.AppDelegateImpl
import org.koin.dsl.module

val mainAppModules = module {
    single<AppDelegate> { AppDelegateImpl(getKoin(), get()) }
}