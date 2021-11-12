package com.carvana.android.account.di

import com.carvana.android.account.public.AccountInterface
import com.carvana.android.common.utils.AppCompPublicFace
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val accountCompPublicDi = module {
    single { AccountInterface(androidContext()) } bind AppCompPublicFace::class
}
