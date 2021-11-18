package com.carvana.android.explore.network

import com.carvana.android.explore.models.User
import retrofit2.Response
import retrofit2.http.GET

/**
 * Defines all the user network restful api
 */
interface UserRestfulApis {

    @GET("user/data")
    suspend fun getUser(): Response<User>
}