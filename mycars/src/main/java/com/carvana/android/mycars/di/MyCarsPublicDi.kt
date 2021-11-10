package com.carvana.android.mycars.di

import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.mycars.public.MyCardsInterface
import org.koin.dsl.bind
import org.koin.dsl.module

val myCarsCompPublicDi = module {
    single { MyCardsInterface() } bind AppCompPublicFace::class
}
