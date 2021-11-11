package com.carvana.android.explore.public

import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.models.AppMainEntry
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.explore.R
import com.carvana.android.explore.di.accountMainModule
import com.carvana.android.explore.di.viewModels
import com.carvana.android.common.R as commonR

/**
 * Account Public Interface Implementer
 */
class ExploreInterface : AppCompPublicFace {

    override fun getDetails(): AppComponentInfo = AppComponentInfo(
        id = commonR.id.Explore_id,
        type = AppComponent.Explore,
        mainEntry = AppMainEntry(
            order = 0,
            label = R.string.explore_comp_label,
            icon = null,
            navGraph = R.navigation.explore_main_nav_graph,
            home = true
        ),
        objectGraph = listOf(accountMainModule, viewModels)
    )

    override fun navigateTo(feature: AppFeature) {
        if (feature !in getDetails().type.features) {
            // do nothing, associated component does not support target feature
        }
    }
}