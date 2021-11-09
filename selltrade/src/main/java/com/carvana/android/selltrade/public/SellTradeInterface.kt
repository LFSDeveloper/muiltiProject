package com.carvana.android.selltrade.public

import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.R as commonR
import com.carvana.android.common.models.AppComponentDetails
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.models.AppMainEntry
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.selltrade.R
import com.carvana.android.selltrade.di.accountMainModule
import com.carvana.android.selltrade.di.viewModels

/**
 * Account Public Interface Implementer
 */
class SellTradeInterface : AppCompPublicFace {

    override fun getDetails(): AppComponentDetails = AppComponentDetails(
        id = commonR.id.SellTrade_id,
        type = AppComponent.SellTrade,
        mainEntryPoint = AppMainEntry(
            id = commonR.id.SellTrade_id,
            order = 1,
            label = R.string.sell_trade_comp_label,
            icon = null,
            mainNav = R.navigation.sell_trade_main_nav_graph,
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