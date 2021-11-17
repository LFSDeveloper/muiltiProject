package com.carvana.android.account.harnessap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carvana.android.account.harnessap.databinding.FragmentStartBinding
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo

/**
 * Implements the account harness app start screen
 */
class HarnessStartFragment : AppBaseFragment() {

    private var viewBinding: FragmentStartBinding? = null

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.start_fragment_title,
        isTop = true
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentStartBinding.inflate(layoutInflater, container, false)
        viewBinding?.apply {
            startAccount.setOnClickListener {
                navController?.navigate(R.id.action_harnessStartFragment_to_account_main_nav_graph)
            }
        }

        return viewBinding?.root
    }
}