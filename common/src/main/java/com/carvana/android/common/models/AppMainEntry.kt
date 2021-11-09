package com.carvana.android.common.models

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.annotation.StringRes

/**
 * Describes an app main entry point for ComponentDetails be part of.
 *
 * @param id to identify this [AppMainEntry] among other possible main entries.
 * @param order in which an instance of [AppMainEntry] will be displayed.
 * @param label to be shown on the app entity that displays an instance of this [AppMainEntry].
 * @param icon that should accompany [label].
 * @param mainNav (NavGraph) to be used through this main entry point.
 * @param home tells if this [AppMainEntry] instance will be the very first entry point among
 * other [AppMainEntry] instances.
 */
data class AppMainEntry(
    @IdRes val id: Int,
    val order: Int,
    @StringRes val label: Int,
    @DrawableRes val icon: Int? = null,
    @NavigationRes val mainNav: Int,
    val home: Boolean = false
)
