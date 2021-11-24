package com.carvana.android.common.utils.dsl

import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppMainEntry

/**
 * Builder function that produces an initialized [AppComponentInfo] instance
 *
 * @param init receiver lambda in charge of initialize the returning instance
 */
fun appComponent(init: AppComponentInfo.() -> Unit) = AppComponentInfo().apply(init)

/**
 * [AppComponentInfo] ext func to inject an instance of [AppMainEntry]
 */
fun AppComponentInfo.createMainEntry(init: AppMainEntry.() -> Unit) {
    mainEntry = AppMainEntry().apply(init)
}