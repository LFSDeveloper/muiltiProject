package com.carvana.android.myapplication.utils

/**
 * Define all app flavors to better run app logic
 * This should match any gradle defined flavor
 *
 * @param buildType associate this any app flavor
 * @param flavor name matching flavor declared within gradle
 */
sealed class AppFlavor(
    val buildType: AppBuildType,
    val flavor: String
) {

    val name: String
        get() = "$flavor$buildType"

    /**
     * Defines the app Dev flavor
     */
    class Dev(buildType: AppBuildType) : AppFlavor(buildType, "dev")

    /**
     * Defines the app Test flavor
     */
    class Test(buildType: AppBuildType) : AppFlavor(buildType, "tst")

    /**
     * Defines the app Prod flavor
     */
    class Prod(buildType: AppBuildType) : AppFlavor(buildType, "prod")

    companion object {

        /**
         * Creates an app flavor associated to [buildType]
         */
        fun getFlavor(buildType: AppBuildType, name: String): AppFlavor? {
            val appFlavors = listOf(
                Dev(buildType), Test(buildType), Prod(buildType)
            )

            return appFlavors.find { it.flavor == name }
        }
    }
}