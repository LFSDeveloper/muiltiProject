package com.carvana.android.explore.di

import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.explore.public.ExploreInterface
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val exploreCompPublicDi = module {
    single { ExploreInterface(androidContext()) } bind AppCompPublicFace::class
}
