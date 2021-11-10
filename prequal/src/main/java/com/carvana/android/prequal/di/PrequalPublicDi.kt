package com.carvana.android.prequal.di

import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.prequal.public.PrequalInterface
import org.koin.dsl.bind
import org.koin.dsl.module

val prequalCompPublicDi = module {
    single<AppCompPublicFace> { PrequalInterface() } bind AppCompPublicFace::class
}
