package com.carvana.android.selltrade.harnessapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo
import com.carvana.android.selltrade.harnessapp.databinding.FragmentHarnessStartBinding

class HarnessStartFragment: AppBaseFragment() {

    private var viewBinding: FragmentHarnessStartBinding? = null

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.sell_trade_harness_app_start_screen,
        isTop = true
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHarnessStartBinding.inflate(inflater, container, false)
        viewBinding?.goIntoSellTrade?.setOnClickListener {
            navController?.navigate(R.id.action_harnessStartFragment_to_account_main_nav_graph)
        }

        return viewBinding?.root
    }
}