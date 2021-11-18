package com.carvana.android.myapplication.network.authenticators

import android.app.Application
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class AppAuthenticator1(
    private val context: Application
): Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        return response.request().newBuilder().build()
    }
}