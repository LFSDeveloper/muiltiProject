package com.carvana.android.myapplication.network

import android.app.Application
import com.carvana.android.common.utils.NetworkSpec
import com.carvana.android.myapplication.network.authenticators.AppAuthenticator2
import com.carvana.android.myapplication.network.interceptors.AppInterceptor1
import com.carvana.android.myapplication.network.interceptors.AppInterceptor2
import com.carvana.android.myapplication.network.interceptors.AppInterceptor3
import com.carvana.android.myapplication.network.interceptors.TimeOutInterceptor
import com.carvana.android.myapplication.utils.AppEnvironment
import okhttp3.Authenticator
import okhttp3.Interceptor
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

class AppNetworkSpecImpl(
    private val context: Application,
    private val environment: AppEnvironment
) : NetworkSpec() {

    override fun getInterceptors(base: List<Interceptor>): List<Interceptor> {
        return listOf(
            AppInterceptor1(context), AppInterceptor2(context), AppInterceptor3(context),
            TimeOutInterceptor(context, environment)
        )
    }

    override fun getAuthenticator(): Authenticator? = AppAuthenticator2(context)

    override fun getConverters(): List<Converter.Factory> = listOf(GsonConverterFactory.create())
}