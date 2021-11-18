package com.carvana.android.mycars.harnessapp

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.carvana.android.common.bases.AppBaseActivity
import com.carvana.android.mycars.harnessapp.databinding.ActivityMainBinding

class MainActivity : AppBaseActivity() {

    private var viewBinding: ActivityMainBinding? = null

    override val navController: NavController?
        get() =  (supportFragmentManager.findFragmentById(
            R.id.app_nav_host_fragment
        ) as? NavHostFragment)?.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}