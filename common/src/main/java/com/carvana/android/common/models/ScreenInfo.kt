package com.carvana.android.common.models

import androidx.annotation.StringRes

/**
 * Describe all the screen information
 *
 * @param title to show on the toolbar
 * @param isTop tells if the associated screen is the start of an entire flow (No navigation icon)
 */
data class ScreenInfo(
    @StringRes val title: Int,
    val isTop: Boolean = false
)
