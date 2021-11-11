package com.carvana.android.prequal.public

import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.prequal.di.accountMainModule
import com.carvana.android.prequal.di.viewModels
import com.carvana.android.common.R as commonR

/**
 * Account Public Interface Implementer
 */
class PrequalInterface : AppCompPublicFace {

    override fun getDetails(): AppComponentInfo = AppComponentInfo(
        id = commonR.id.Prequal_id,
        type = AppComponent.Prequal,
        mainEntry = null,
        objectGraph = listOf(accountMainModule, viewModels)
    )

    override fun navigateTo(feature: AppFeature) {
        if (feature !in getDetails().type.features) {
            // do nothing, associated component does not support target feature
        }
    }
}