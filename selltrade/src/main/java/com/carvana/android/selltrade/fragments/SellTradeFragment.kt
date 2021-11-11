package com.carvana.android.selltrade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.selltrade.R

/**
 * Represents the SellTrade landing Screen
 */
class SellTradeFragment: AppBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sell_trade, container, false)

        view.findViewById<Button>(R.id.button)?.apply {
            setOnClickListener {
                navController?.navigate(R.id.action_sellTradeFragment_to_nextStepsFragment)
            }
        }
        return view
    }
}