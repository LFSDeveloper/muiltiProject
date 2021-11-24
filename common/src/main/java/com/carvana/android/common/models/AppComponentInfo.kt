package com.carvana.android.common.models

import androidx.annotation.IdRes
import org.koin.core.module.Module

/**
 * Describes an App Components on the following terms
 *
 * @param id to uniquely identify a component described by an instance of [AppComponentInfo].
 * This resource should be generated within the same package name.
 * @param type of component and instance of [AppComponentInfo] describes.
 * @param mainEntry should be implemented if the component described by an instance
 * of [AppComponentInfo] wants to be part as one of the App main navigation entries.
 * @param objectGraph that the related component relays on thru the dependency injection framework.
 *
 * Note:
 * A Component represents a set of features that can be related from an app perspective and
 * that can exist in isolation even when some internal features can be shared.
 *
 * For example, must of the features a user interacts within the explore flow could
 * be put into an Explore Component (SRP, VDP, Filters)
 */
data class AppComponentInfo(
    @IdRes var id: Int = -1,
    var type: AppComponent? = null,
    var mainEntry: AppMainEntry? = null,
    var objectGraph: List<Module> = listOf()
) {

    /**
     * Tells if the described component is part of the app main entries
     */
    val isMainAppEntry: Boolean
        get() = mainEntry != null
}
