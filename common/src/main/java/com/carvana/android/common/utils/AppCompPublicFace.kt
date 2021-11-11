package com.carvana.android.common.utils

import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature

/**
 * Defines an app component public interface used
 */
interface AppCompPublicFace {

    /**
     * Offers a component description
     */
    fun getDetails(): AppComponentInfo

    /**
     * Handles the navigation to an internal section of a component
     */
    fun navigateTo(feature: AppFeature)
}