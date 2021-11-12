package com.carvana.android.common.bases

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.carvana.android.common.R
import com.carvana.android.common.databinding.ActivityBaseModalBinding

/**
 * Base Actiivty to all modal screens.
 */
abstract class AppBaseModalActivity : AppBaseActivity() {

    private var bindingView: ActivityBaseModalBinding? = null

    /**
     * Forces Modal Activity children to specify their navigation graph to use during modal flow
     */
    @NavigationRes
    abstract fun getModalNavGraph(): Int

    final override val navController: NavController?
        get() = (supportFragmentManager.findFragmentById(
            R.id.app_base_modal_activity_nav_host
        ) as? NavHostFragment)?.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_base_modal)
        navController?.setGraph(getModalNavGraph())
    }
}