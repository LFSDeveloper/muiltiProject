package com.carvana.android.common.models

import androidx.annotation.IdRes

/**
 * Describes an App Components on the following terms
 *
 * @param id to uniquely identify and instance of [AppComponentDetails]. The is resource should be
 * generated within the same package name
 * @param type of component an instance of
 * @param mainEntryPoint information if an instance of [AppComponentDetails] wants to be part of
 * the app main entre points. Right now this is driven from the app bottom navigation bar.
 * @param objectGraph that a component relays on thru the dependency injection framework.
 *
 * Note:
 * A Component represents a set of features that can be related from an app perspective and
 * that can exist in isolation even when some internal features can be shared.
 *
 * For example, must of the features a user interacts within the explore flow could
 * be put into an Explore Component (SRP, VDP, Filters)
 */
data class AppComponentDetails(
    @IdRes val id: Int,
    val type: AppComponent,
    val mainEntryPoint: AppMainEntry? = null,
    val objectGraph: List<Int>
)
