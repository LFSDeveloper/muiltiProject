package com.carvana.android.selltrade.public

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.carvana.android.common.models.AppComponent
import com.carvana.android.common.models.AppComponentInfo
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.models.AppMainEntry
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.selltrade.R
import com.carvana.android.selltrade.di.accountMainModule
import com.carvana.android.selltrade.di.viewModels
import com.carvana.android.common.R as commonR

/**
 * Account Public Interface Implementer
 */
class SellTradeInterface(
    context: Context
) : AppCompPublicFace(context) {

    override fun getInfo(): AppComponentInfo = AppComponentInfo(
        id = commonR.id.SellTrade_id,
        type = AppComponent.SellTrade,
        mainEntry = AppMainEntry(
            order = 1,
            label = R.string.sell_trade_comp_label,
            icon = null,
            navGraph = R.navigation.sell_trade_main_nav_graph,
            home = false
        ),
        objectGraph = listOf(accountMainModule, viewModels)
    )

    override fun getLaunchingIntent(feature: AppFeature, bundle: Bundle?): Intent? {
        return null
    }
}