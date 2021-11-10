package com.carvana.android.explore.di

import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.explore.public.ExploreInterface
import org.koin.dsl.bind
import org.koin.dsl.module

val exploreCompPublicDi = module {
    single<AppCompPublicFace> { ExploreInterface() } bind AppCompPublicFace::class
}
