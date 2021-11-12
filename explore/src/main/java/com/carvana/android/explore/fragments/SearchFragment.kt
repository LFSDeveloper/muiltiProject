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

class SearchFragment : AppBaseFragment() {

    private val appDelegate: AppDelegate by inject()

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.explore_search_screen_title
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        view.findViewById<Button>(R.id.prequal_button)?.apply {
            setOnClickListener {
                appDelegate.navigateTo(AppFeature.PrequalHome)
            }
        }

        return view
    }
}