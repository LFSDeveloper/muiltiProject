package com.carvana.android.account.harnessap

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.carvana.android.account.harnessap.databinding.ActivityMainBinding
import com.carvana.android.common.bases.AppBaseActivity

class MainActivity : AppBaseActivity() {

    private var viewBinding: ActivityMainBinding? = null

    override val navController: NavController?
        get() = viewBinding?.appNavHostFragment?.findNavController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}