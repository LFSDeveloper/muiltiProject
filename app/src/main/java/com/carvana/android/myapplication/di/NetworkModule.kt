package com.carvana.android.myapplication.di

import android.app.Application
import com.carvana.android.common.utils.RestFulFactory
import com.carvana.android.myapplication.network.authenticators.AppAuthenticator1
import com.carvana.android.myapplication.network.authenticators.AppAuthenticator2
import com.carvana.android.myapplication.network.interceptors.AppInterceptor1
import com.carvana.android.myapplication.network.interceptors.AppInterceptor2
import com.carvana.android.myapplication.network.interceptors.AppInterceptor3
import com.carvana.android.myapplication.network.utils.RestFulFactoryImpl
import com.carvana.android.myapplication.utils.AppEnvironment
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { getOkHttpClient(androidApplication()) }
    single { getRetrofit(get(), get()) }
    single<RestFulFactory> { RestFulFactoryImpl(get()) }
}

private fun getOkHttpClient(context: Application): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(AppInterceptor1(context))
        .addInterceptor(AppInterceptor2(context))
        .addInterceptor(AppInterceptor3(context))
        .authenticator(AppAuthenticator1(context))
        .authenticator(AppAuthenticator2(context))
        .build()
}

private fun getRetrofit(okHttpClient: OkHttpClient, environment: AppEnvironment): Retrofit {
    return Retrofit.Builder()
        .baseUrl(environment.baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}