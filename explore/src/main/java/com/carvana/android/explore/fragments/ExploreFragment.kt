package com.carvana.android.explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.bases.AppDelegate
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.models.ScreenInfo
import com.carvana.android.explore.R
import org.koin.android.ext.android.inject

/**
 * Represents the Explore Component Landing Screen
 */
class ExploreFragment : AppBaseFragment() {

    private val appDelegate: AppDelegate by inject()

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.explore_screen_title,
        isTop = true
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentView = inflater.inflate(R.layout.fragment_explore, container, false)

        // navigates internally
        fragmentView.findViewById<Button>(R.id.button)?.apply {
            setOnClickListener {
                navController?.navigate(R.id.action_Explore_id_to_searchFragment)
            }
        }

        // navigate into another component
        fragmentView.findViewById<Button>(R.id.go_to_account)?.apply {
            setOnClickListener {
                appDelegate.navigateTo(AppFeature.AccountHome)
            }
        }


        return fragmentView
    }
}