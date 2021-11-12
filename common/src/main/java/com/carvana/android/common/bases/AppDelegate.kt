package com.carvana.android.common.bases

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.carvana.android.common.models.AppFeature

/**
 * Defines the Application public interface that components can use to
 *
 * a. navigate from one to another
 * b. request data dependency owned by other components
 * c. request any other dependency not own by a component
 *
 * Note: Harness apps needs to provide an implementation of this interface
 */
interface AppDelegate {

    /**
     * Delivers navigation notifications into app Component
     *
     * TODO: check the option of having all app activities within same task
     * In this case, if a navigation takes place from a modal activity into main
     * then main can be relaunched as single top/task and all modals will be dismissed automatically
     */
    val mainAppNavFlow: LiveData<AppNavFeature>

    /**
     * Navigates into an app feature
     *
     * @param feature to navigate into
     * @param bundle of data to pass into the feature when called. This is optional
     */
    fun navigateTo(feature: AppFeature, bundle: Bundle? = null)
}

/**
 * Describes an app feature navigation request
 */
data class AppNavFeature(
    val feature: AppFeature? = null,
    val bundle: Bundle? = null
)