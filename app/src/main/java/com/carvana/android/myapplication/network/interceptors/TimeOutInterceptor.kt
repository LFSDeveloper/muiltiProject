package com.carvana.android.myapplication.network.interceptors

import android.app.Application
import com.carvana.android.explore.network.UserRestfulApis
import com.carvana.android.myapplication.utils.AppEnvironment
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Invocation
import java.util.concurrent.TimeUnit

/**
 * Changes a request time out based on request type
 *
 * @param context
 * @param environment from specific timeouts can be fetched
 */
class TimeOutInterceptor(
    private val context: Application,
    private val environment: AppEnvironment
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // get a request copy
        val request = chain.request()

        val isUserApi = request.isClassType(UserRestfulApis::class.java)
        val isGetUserCall = request.isOfMethod("getUser")

        val newChain = isGetUserCall.takeIf { it }?.let {
            chain.withConnectTimeout(
                environment.userRequestTimeout,
                TimeUnit.MILLISECONDS
            )
        }

        return newChain?.proceed(request) ?: chain.proceed(chain.request())
    }
}

/**
 * Request ext function that tells if a request belongs to any defined method of
 * a Retrofit specific interface
 *
 * @param clazz of a predefines retrofit interface
 */
fun <T : Any> Request.isClassType(clazz: Class<T>): Boolean {
    val invocation = tag(Invocation::class.java)
    return invocation?.method()?.declaringClass == clazz
}

/**
 * Request ext fun that tells if a request is directly associated to a Retrofit interface
 * specific method name
 *
 * @param name of the method invoking this request on a retrofit interface
 */
fun Request.isOfMethod(name: String): Boolean {
    val invocation = tag(Invocation::class.java)
    val invocationMethod = invocation?.method()

    return invocationMethod?.name == name
}