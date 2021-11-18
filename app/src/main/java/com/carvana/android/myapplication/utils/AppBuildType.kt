package com.carvana.android.myapplication.utils

/**
 * Defines all the app build types from a logical perspective.
 *
 * Note:
 * a. This serves to run app logic in a better code perspective.
 * b. This enum should match any gradle defined build type
 *
 * @param type of the build type name defined in gradle file
 */
enum class AppBuildType(
    val type: String
) {
    Debug("debug"),
    Release("release")

}