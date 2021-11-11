package com.carvana.android.explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.explore.R

/**
 * Represents the Explore Component Landing Screen
 */
class ExploreFragment : AppBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.fragment_explore, container, false)

        fragmentView.findViewById<Button>(R.id.button)?.apply {
            setOnClickListener {
                navController?.navigate(R.id.action_Explore_id_to_searchFragment)
            }
        }
        return fragmentView
    }
}