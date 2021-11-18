package com.carvana.android.myapplication.utils

import com.carvana.android.myapplication.BuildConfig

/**
 * Describe the app environment based on build variants type
 *
 * @param baseUrl to use based on app build variant
 * @param analyticHeader to use on any analytic tag based on build variant
 */
data class AppEnvironment(
    val baseUrl: String,
    val analyticHeader: String
) {

    /**
     * Returns the app build variant associate with a flavor
     */
    fun buildVariant(): AppFlavor {
        val buildType = AppBuildType.values().find { it.type == BuildConfig.BUILD_TYPE }
        val buildFlavor = buildType?.let { AppFlavor.getFlavor(it, BuildConfig.FLAVOR) }

        return buildFlavor ?: throw IllegalStateException("App Flavor not defined")
    }
}


