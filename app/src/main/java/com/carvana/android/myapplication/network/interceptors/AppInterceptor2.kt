package com.carvana.android.myapplication.network.interceptors

import android.app.Application
import okhttp3.Interceptor
import okhttp3.Response

class AppInterceptor2(
    private val context: Application
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}