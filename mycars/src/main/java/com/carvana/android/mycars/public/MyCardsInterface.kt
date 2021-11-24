package com.carvana.android.mycars.public

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.common.utils.dsl.appComponent
import com.carvana.android.common.utils.dsl.createMainEntry
import com.carvana.android.mycars.R
import com.carvana.android.mycars.di.accountMainModule
import com.carvana.android.mycars.di.viewModels
import com.carvana.android.common.R as commonR

/**
 * Account Public Interface Implementer
 */
class MyCardsInterface(
    context: Context
) : AppCompPublicFace(context) {

    override fun getInfo(): AppComponentInfo = appComponent {
        id = commonR.id.MyCars_id
        type = AppComponent.MyCars
        objectGraph = listOf(accountMainModule, viewModels)

        createMainEntry {
            order = 2
            label = R.string.my_cars_comp_label
            icon = null
            navGraph = R.navigation.mycars_main_nav_graph
            home = false
        }
    }

    override fun getLaunchingIntent(feature: AppFeature, bundle: Bundle?): Intent? {
        return null
    }

}