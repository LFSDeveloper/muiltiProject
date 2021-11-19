package com.carvana.android.myapplication.network.utils

import com.carvana.android.common.utils.RestfulFactory
import retrofit2.Retrofit

/**
 * [RestfulFactory] implementer class
 *
 * This class will be produced as a singleton
 */
class RestFulFactoryImpl(
    private val retrofit: Retrofit
) : RestfulFactory {

    override fun <T : Any> getApi(api: Class<T>): T {
        return retrofit.create(api)
    }
}
