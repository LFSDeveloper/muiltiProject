package com.carvana.android.mycars.harnessapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo
import com.carvana.android.mycars.harnessapp.databinding.FragmentHarnessStartBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HarnessStartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HarnessStartFragment : AppBaseFragment() {

    private var viewBinding: FragmentHarnessStartBinding? = null

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.my_cars_harness_title,
        isTop = true
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHarnessStartBinding.inflate(layoutInflater, container, false)
        viewBinding?.goIntoMycars?.setOnClickListener {
            navController?.navigate(R.id.action_harnessStartFragment_to_account_main_nav_graph)
        }

        return viewBinding?.root
    }
}