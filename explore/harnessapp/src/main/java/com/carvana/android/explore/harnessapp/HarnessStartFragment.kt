package com.carvana.android.explore.harnessapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo
import com.carvana.android.explore.harnessapp.databinding.FragmentHarnnesStartBinding

class HarnessStartFragment : AppBaseFragment() {

    private var viewBinding: FragmentHarnnesStartBinding? = null

    override val screenInfo: ScreenInfo = ScreenInfo(
        R.string.explore_harness_start_screen,
        isTop = true
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHarnnesStartBinding.inflate(inflater, container, false)
        viewBinding?.goIntoExplore?.setOnClickListener {
            navController?.navigate(R.id.action_harnessStartFragment_to_account_main_nav_graph)
        }

        return viewBinding?.root
    }
}