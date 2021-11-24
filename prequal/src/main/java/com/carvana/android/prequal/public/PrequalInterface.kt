package com.carvana.android.prequal.public

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.common.utils.dsl.appComponent
import com.carvana.android.prequal.activities.PrequalModalActivity
import com.carvana.android.prequal.di.accountMainModule
import com.carvana.android.prequal.di.viewModels
import com.carvana.android.common.R as commonR

/**
 * Account Public Interface Implementer
 */
class PrequalInterface(
    context: Context
) : AppCompPublicFace(context) {

    override fun getInfo(): AppComponentInfo = appComponent {
        id = commonR.id.Prequal_id
        type = AppComponent.Prequal
        mainEntry = null
        objectGraph = listOf(accountMainModule, viewModels)
    }

    override fun getLaunchingIntent(feature: AppFeature, bundle: Bundle?): Intent? {
        return when (feature) {
            AppFeature.PrequalHome -> PrequalModalActivity.getIntent(context)
            else -> null
        }
    }
}