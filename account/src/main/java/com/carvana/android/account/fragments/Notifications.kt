package com.carvana.android.account.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carvana.android.account.R
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo

class Notifications: AppBaseFragment() {

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.account_notification_screen_title
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return layoutInflater.inflate(R.layout.fragment_notifications, container, false)
    }

}