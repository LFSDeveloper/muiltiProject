package com.carvana.android.explore.di

import com.carvana.android.explore.repositories.UserRepository
import com.carvana.android.explore.repositories.UserRepositoryImpl
import org.koin.dsl.module

val accountMainModule = module {

    factory<UserRepository> { UserRepositoryImpl(get()) }
}

