package com.carvana.android.myapplication.network.utils

import com.carvana.android.common.utils.RestFulFactory
import retrofit2.Retrofit

/**
 * [RestFulFactory] implementer class
 *
 * This class will be produced as a singleton
 */
class RestFulFactoryImpl(
    private val retrofit: Retrofit
) : RestFulFactory {

    override fun <T : Any> getApi(api: Class<T>): T {
        return retrofit.create(api)
    }
}
