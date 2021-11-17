package com.carvana.android.prequal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo
import com.carvana.android.prequal.R

class PersonalInfoFragment : AppBaseFragment() {

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.prequal_personal_screen_title
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personal_info, container, false)
    }
}