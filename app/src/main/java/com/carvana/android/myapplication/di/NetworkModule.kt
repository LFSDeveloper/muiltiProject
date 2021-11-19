package com.carvana.android.myapplication.di

import android.app.Application
import com.carvana.android.common.utils.RestfulFactory
import com.carvana.android.myapplication.network.authenticators.AppAuthenticator2
import com.carvana.android.myapplication.network.interceptors.TimeOutInterceptor
import com.carvana.android.myapplication.network.utils.RestFulFactoryImpl
import com.carvana.android.myapplication.utils.AppEnvironment
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { getOkHttpClient(androidApplication(), get()) }

    single { getRetrofit(get(), get()) }

    single<RestfulFactory> { RestFulFactoryImpl(get()) }
}

private fun getOkHttpClient(context: Application, environment: AppEnvironment): OkHttpClient {
    return OkHttpClient.Builder()
//        .addInterceptor(AppInterceptor1(context))
//        .addInterceptor(AppInterceptor2(context))
//        .addInterceptor(AppInterceptor3(context))
        .addInterceptor(TimeOutInterceptor(context, environment))
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