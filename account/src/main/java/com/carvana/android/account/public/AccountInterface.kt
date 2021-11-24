package com.carvana.android.account.public

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.carvana.android.account.di.accountMainModule
import com.carvana.android.account.di.accountNetworkModule
import com.carvana.android.account.di.viewModels
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.common.utils.dsl.appComponent
import com.carvana.android.common.utils.dsl.createMainEntry
import com.carvana.android.account.R as accountR

/**
 * Account Public Interface Implementer
 */
class AccountInterface(
    context: Context
) : AppCompPublicFace(context) {

    override fun getInfo(): AppComponentInfo = appComponent {
        id = com.carvana.android.account.R.id.Account_id
        type = AppComponent.Account
        objectGraph = listOf(accountMainModule, viewModels, accountNetworkModule)

        createMainEntry {
            order = 3
            label = accountR.string.account_comp_label
            icon = null
            navGraph = accountR.navigation.account_main_nav_graph
            home = false
        }
    }

    override fun getLaunchingIntent(feature: AppFeature, bundle: Bundle?): Intent? {
        return null
    }
}