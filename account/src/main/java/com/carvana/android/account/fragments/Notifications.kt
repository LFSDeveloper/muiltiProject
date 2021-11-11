package com.carvana.android.account.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.carvana.android.account.R
import com.carvana.android.common.bases.AppBaseFragment

class Notifications: AppBaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_notifications, container, false)
    }
}