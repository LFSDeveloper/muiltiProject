package com.carvana.android.common.utils

import okhttp3.Authenticator
import okhttp3.Interceptor
import retrofit2.Converter

/**
 * Implement this class within a component scope if
 * a. wants to add custom interceptor into the network layer
 * b. wants to replaces the app network authenticator
 */
open class NetworkSpec {

    /**
     * Returns the new interceptor list to be used by the app network layer
     *
     * @param base interceptor list used within app by default. This allows a component to
     * filter some base interceptors out. Make sure the returning list includes the base elements too
     *
     * @return the new interceptor list to be used by network. This list should include the
     * elements passed within [base] arg or some of them if manipulated
     */
    open fun getInterceptors(base: List<Interceptor>): List<Interceptor> = listOf()

    /**
     * Replaces the app network layer authenticator by the specified one
     */
    open fun getAuthenticator(): Authenticator? = null

    /**
     * Specifies a list of network converters
     */
    open fun getConverters(): List<Converter.Factory> = listOf()
}