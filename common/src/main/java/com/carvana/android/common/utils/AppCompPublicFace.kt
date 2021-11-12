package com.carvana.android.common.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature

/**
 * Defines an app component public interface used
 */
abstract class AppCompPublicFace(
    protected val context: Context
) {

    /**
     * Maps a Component Feature into is Navigation Destination id.
     * This utility method serves as a main app helper to orchestrate global navigation
     * into different levels of component public navigation.
     * From main app one component can request navigate into any destination of another
     * component public navigation flow
     *
     * Ex: AccountComponent -> ExploreComponent -> Srp Feature
     */
    @IdRes
    open fun getDestinationId(feature: AppFeature): Int? = null

    /**
     * Offers a component description
     */
    abstract fun getInfo(): AppComponentInfo

    /**
     * Allow Components to produce launching intents from those features exposed
     * to the external world.
     *
     * @param feature to navigate into.
     * @param bundle data set to pass into [feature] main entry screen
     *
     * @return an intent that be used to launch an activity
     */
    abstract fun getLaunchingIntent(feature: AppFeature, bundle: Bundle? = null): Intent?

    /**
     * Handles the navigation to an internal section of a component
     *
     * @param feature to navigate into.
     * @param bundle data set to pass into [feature] main entry screen
     */
    fun navigateTo(feature: AppFeature, bundle: Bundle? = null) {
        val isFeatureImpl = feature in getInfo().type.features
        isFeatureImpl.takeIf { it } ?: return

        val launchingIntent = getLaunchingIntent(feature, bundle)
        launchingIntent?.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }

        launchingIntent?.let(context::startActivity)
    }
}