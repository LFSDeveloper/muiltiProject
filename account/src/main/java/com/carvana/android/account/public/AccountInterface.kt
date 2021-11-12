package com.carvana.android.account.public

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.carvana.android.account.R
import com.carvana.android.account.di.accountMainModule
import com.carvana.android.account.di.viewModels
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.models.AppMainEntry
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.common.R as commonR

/**
 * Account Public Interface Implementer
 */
class AccountInterface(
    context: Context
) : AppCompPublicFace(context) {

    override fun getInfo(): AppComponentInfo = AppComponentInfo(
        id = commonR.id.Account_id,
        type = AppComponent.Account,
        mainEntry = AppMainEntry(
            order = 3,
            label = R.string.account_comp_label,
            icon = null,
            navGraph = R.navigation.account_main_nav_graph,
            home = false
        ),
        objectGraph = listOf(accountMainModule, viewModels)
    )

    override fun getLaunchingIntent(feature: AppFeature, bundle: Bundle?): Intent? {
        return null
    }
}