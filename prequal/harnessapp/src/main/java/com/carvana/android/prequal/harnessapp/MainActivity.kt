package com.carvana.android.prequal.harnessapp

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.carvana.android.common.bases.AppBaseActivity
import com.carvana.android.prequal.harnessapp.databinding.ActivityMainBinding

class MainActivity : AppBaseActivity() {

    private var viewBinding: ActivityMainBinding? = null

    override val navController: NavController?
        get() = viewBinding?.appNavHostFragment?.findNavController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}