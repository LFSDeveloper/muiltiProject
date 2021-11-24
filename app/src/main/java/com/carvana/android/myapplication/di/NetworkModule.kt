package com.carvana.android.myapplication.di

import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.utils.NetworkSpec
import com.carvana.android.common.utils.RestfulFactory
import com.carvana.android.myapplication.network.AppNetworkSpecImpl
import com.carvana.android.myapplication.network.utils.RestFulFactoryImpl
import com.carvana.android.myapplication.utils.AppEnvironment
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit

val networkSpecModule = module {

    // generates the main app network specs
    factory<NetworkSpec>(qualifier = named(AppComponent.MainApp)) {
        AppNetworkSpecImpl(androidApplication(), get())
    }
}

val networkModule = module {

    // generate an instance of okHttp Client
    single {
        val environment: AppEnvironment? = getOrNull()
        val networkSpec: NetworkSpec? = getOrNull()

//        getOkHttpClient(androidApplication(), get(), interceptor)
    }

    // generates an instance of retrofit
    single { getRetrofit(get(), get()) }

    // generates an instance of the App network factory used to perform api calls
    single<RestfulFactory> { RestFulFactoryImpl(get()) }


}

private fun getOkHttpClient(
    authenticator: Authenticator,
    interceptors: List<Interceptor> = listOf()
): OkHttpClient {
    return OkHttpClient.Builder()
        .apply {
            interceptors.forEach(::addInterceptor)
        }.authenticator(authenticator)
        .build()
}

private fun getRetrofit(
    okHttpClient: OkHttpClient,
    environment: AppEnvironment,
    converters: List<Converter.Factory> = listOf()
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(environment.baseUrl)
        .client(okHttpClient)
        .apply { converters.forEach(::addConverterFactory) }
        .build()
}