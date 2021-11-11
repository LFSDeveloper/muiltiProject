package com.carvana.android.common.bases

import androidx.fragment.app.Fragment
import androidx.navigation.NavController

abstract class AppBaseFragment : Fragment() {

    /**
     * Exposes the App navController down to all fragments
     */
    protected val navController: NavController?
        get() = (activity as? AppBaseActivity)?.navController
}