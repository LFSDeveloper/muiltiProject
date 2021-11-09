package com.carvana.android.prequal.public

import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.R as commonR
import com.carvana.android.common.models.AppComponentDetails
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.prequal.di.accountMainModule
import com.carvana.android.prequal.di.viewModels

/**
 * Account Public Interface Implementer
 */
class PrequalInterface : AppCompPublicFace {

    override fun getDetails(): AppComponentDetails = AppComponentDetails(
        id = commonR.id.Prequal_id,
        type = AppComponent.Prequal,
        mainEntryPoint = null,
        objectGraph = listOf(accountMainModule, viewModels)
    )

    override fun navigateTo(feature: AppFeature) {
        if (feature !in getDetails().type.features) {
            // do nothing, associated component does not support target feature
        }
    }
}