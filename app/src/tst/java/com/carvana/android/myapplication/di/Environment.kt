package com.carvana.android.myapplication.di

import com.carvana.android.myapplication.utils.AppEnvironment
import org.koin.dsl.module

val environmentModule = module {

    single {
        AppEnvironment(
            "https://www.backend-test.com",
            "test:"
        )
    }
}