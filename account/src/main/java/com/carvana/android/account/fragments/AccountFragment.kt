package com.carvana.android.account.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.carvana.android.account.R
import com.carvana.android.common.bases.AppBaseFragment
import com.carvana.android.common.models.ScreenInfo

/**
 * Represents the Account Landing Screen
 */
class AccountFragment: AppBaseFragment() {

    override val screenInfo: ScreenInfo = ScreenInfo(
        title = R.string.account_screen_title,
        isTop = true
    )

    override fun generateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentView = inflater.inflate(R.layout.fragment_account, container, false)

        fragmentView.findViewById<Button>(R.id.button)?.apply {
            setOnClickListener {
                navController?.navigate(R.id.action_accountFragment_to_notifications)
            }
        }

        return fragmentView
    }
}