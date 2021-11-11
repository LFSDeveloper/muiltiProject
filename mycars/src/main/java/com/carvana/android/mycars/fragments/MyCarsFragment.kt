package com.carvana.android.mycars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo
import com.carvana.android.mycars.R

/**
 * Represents the MyCars Component main entry screen
 */
class MyCarsFragment: AppBaseFragment() {

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.my_cars_screen_title,
        isTop = true
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_my_cars, container, false)

        view.findViewById<Button>(R.id.button)?.apply {
            setOnClickListener {
                navController?.navigate(R.id.action_myCarsFragment_to_favoriteFragment)
            }
        }
        return view
    }
}