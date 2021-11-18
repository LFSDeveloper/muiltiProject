package com.carvana.android.explore.di

import com.carvana.android.explore.fragments.explore.ExploreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { ExploreViewModel(get()) }
}