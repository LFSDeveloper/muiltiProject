package com.carvana.android.common.models

import androidx.annotation.DrawableRes
import androidx.annotation.NavigationRes
import androidx.annotation.StringRes

/**
 * Describes an app main entry point for ComponentDetails be part of.
 *
 * @param order in which an instance of [AppMainEntry] will be displayed.
 * @param label to be shown on the app entity that displays an instance of this [AppMainEntry].
 * @param icon that should accompany [label].
 * @param navGraph (NavGraph) to be used through this main entry point.
 * @param home tells if this [AppMainEntry] instance will be the very first entry point among
 * other [AppMainEntry] instances.
 */
data class AppMainEntry(
    val order: Int,
    @StringRes val label: Int,
    @DrawableRes val icon: Int? = null,
    @NavigationRes val navGraph: Int,
    val home: Boolean = false
)
