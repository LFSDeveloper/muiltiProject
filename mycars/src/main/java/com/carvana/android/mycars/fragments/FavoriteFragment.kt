package com.carvana.android.mycars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.bases.AppDelegate
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.models.ScreenInfo
import com.carvana.android.mycars.R
import org.koin.android.ext.android.inject

class FavoriteFragment : AppBaseFragment() {

    private val appDelegate: AppDelegate by inject()

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.my_cars_favorite_screen_title
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        view.findViewById<Button>(R.id.search_modal)?.apply {
            setOnClickListener {
                appDelegate.navigateTo(AppFeature.SrpModal)
            }
        }

        view.findViewById<Button>(R.id.search_screen)?.apply {
            setOnClickListener {
                appDelegate.navigateTo(AppFeature.Srp)
            }
        }

        return view
    }

}