package com.carvana.android.explore.repositories

import com.carvana.android.common.utils.RestfulFactory
import com.carvana.android.explore.models.User
import com.carvana.android.explore.network.UserRestfulApis

interface UserRepository {

    /**
     * Returns the user Info
     */
    suspend fun getUser(): User?
}

class UserRepositoryImpl(
    private val networkFactory: RestfulFactory
) : UserRepository {


    override suspend fun getUser(): User? {
        val userApi = networkFactory.getApi(UserRestfulApis::class.java)
        val userResponse = userApi.getUser()

        return when (userResponse.isSuccessful) {
            true -> userResponse.body()
            else -> {
                // do some error handling
                null
            }
        }
    }
}