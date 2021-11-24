package com.carvana.android.myapplication.di

import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.myapplication.publicIn.MainAppInterface
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val mainAppPublicDi = module {
    single { MainAppInterface(androidContext()) } bind AppCompPublicFace::class
}