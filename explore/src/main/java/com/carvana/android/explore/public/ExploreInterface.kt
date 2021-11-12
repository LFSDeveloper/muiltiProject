package com.carvana.android.explore.public

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.models.AppMainEntry
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.explore.R
import com.carvana.android.explore.activities.SearchModalActivity
import com.carvana.android.explore.di.accountMainModule
import com.carvana.android.explore.di.viewModels
import com.carvana.android.common.R as commonR

/**
 * Account Public Interface Implementer
 */
class ExploreInterface(
    context: Context
) : AppCompPublicFace(context) {

    override fun getInfo(): AppComponentInfo = AppComponentInfo(
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

    override fun getLaunchingIntent(feature: AppFeature, bundle: Bundle?): Intent? {
        return when (feature) {
            AppFeature.SrpModal -> SearchModalActivity.getLaunchIntent(context)
            else -> null
        }
    }

    override fun getDestinationId(feature: AppFeature): Int? {
        return when (feature) {
            AppFeature.Srp -> R.id.action_Explore_id_to_searchFragment
            else -> null
        }
    }
}