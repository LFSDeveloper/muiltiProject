package com.carvana.android.myapplication.di

import com.carvana.android.myapplication.activities.AppMainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AppMainActivityViewModel() }
}