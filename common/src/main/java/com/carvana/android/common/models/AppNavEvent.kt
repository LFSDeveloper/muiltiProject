package com.carvana.android.common.models

import android.os.Bundle
import androidx.annotation.IdRes

/**
 * Defines a navigation event passed into UI from ViewModel
 *
 * @param destinationId of the navigate to destination/action
 * @param bundle of data to pass into [destinationId]
 */
data class AppNavEvent(
    @IdRes val destinationId: Int,
    val bundle: Bundle? = null
)
