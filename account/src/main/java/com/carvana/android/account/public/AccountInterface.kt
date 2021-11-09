package com.carvana.android.account.public

import com.carvana.android.account.R
import com.carvana.android.account.di.accountMainModule
import com.carvana.android.account.di.viewModels
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.R as commonR
import com.carvana.android.common.models.AppComponentDetails
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.models.AppMainEntry
import com.carvana.android.common.utils.AppCompPublicFace

/**
 * Account Public Interface Implementer
 */
class AccountInterface : AppCompPublicFace {

    override fun getDetails(): AppComponentDetails = AppComponentDetails(
        id = commonR.id.Account_id,
        type = AppComponent.Account,
        mainEntryPoint = AppMainEntry(
            id = commonR.id.Account_id,
            order = 3,
            label = R.string.account_comp_label,
            icon = null,
            mainNav = R.navigation.account_main_nav_graph,
            home = false
        ),
        objectGraph = listOf(accountMainModule, viewModels)
    )

    override fun navigateTo(feature: AppFeature) {
        if (feature !in getDetails().type.features) {
            // do nothing, associated component does not support target feature
        }
    }
}