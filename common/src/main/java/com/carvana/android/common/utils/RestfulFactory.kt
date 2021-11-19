package com.carvana.android.common.utils

/**
 * Defines the Network Layer Factory Api
 */
interface RestfulFactory {

    /**
     * Produces a Retrofit Api Interface
     */
    fun <T : Any> getApi(api: Class<T>): T
}
