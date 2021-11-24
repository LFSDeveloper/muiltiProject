package com.carvana.android.account.utils

import android.content.Context
import com.carvana.android.common.utils.NetworkSpec
import okhttp3.Interceptor

class AccountNetworkImpl(
    private val context: Context
) : NetworkSpec() {

    override fun getInterceptors(base: List<Interceptor>): List<Interceptor> {
        return base + listOf()
    }
}