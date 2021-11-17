package com.carvana.android.prequal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo
import com.carvana.android.prequal.R

/**
 * Represents the Prequal Component Landing Screen
 */
class PrequalFragment : AppBaseFragment() {

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.prequal_screen_title,
        isTop = true
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prequal, container, false)

        view.findViewById<Button>(R.id.button)?.apply {
            setOnClickListener {
                navController?.navigate(R.id.action_prequalFragment_to_personalInfoFragment)
            }
        }
        return view
    }

}