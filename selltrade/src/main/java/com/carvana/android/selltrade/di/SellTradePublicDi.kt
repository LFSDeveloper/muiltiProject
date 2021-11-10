package com.carvana.android.selltrade.di

import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.selltrade.public.SellTradeInterface
import org.koin.dsl.bind
import org.koin.dsl.module

val sellTradeCompPublicDi = module {
    single<AppCompPublicFace> { SellTradeInterface() } bind AppCompPublicFace::class
}
