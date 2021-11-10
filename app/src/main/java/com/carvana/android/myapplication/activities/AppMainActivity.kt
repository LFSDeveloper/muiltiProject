package com.carvana.android.myapplication.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.carvana.android.myapplication.R
import com.carvana.android.myapplication.databinding.ActivityMainBinding
import com.carvana.android.myapplication.utils.AppComponentProvider
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Represent the app main activity as the main navigation host to all the app components
 */
class AppMainActivity : AppCompatActivity() {

    private val viewModel: AppMainActivityViewModel by viewModel()
    private var viewBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        inflateBottomNav()
    }

    /**
     * Inflates the bottom navigator menu out of the main entry components
     */
    private fun inflateBottomNav() {
        // holds the main entry components entry descriptions
        val mainEntryComp = AppComponentProvider.mainEntryComponents.mapNotNull {
            it.getDetails().mainEntryPoint
        }

        val menu = viewBinding?.appNavBar?.menu
        mainEntryComp.forEach { mainEntryInfo ->
            val tabTitle = getString(mainEntryInfo.label)
            val menuItem = menu?.add(Menu.NONE, mainEntryInfo.id, mainEntryInfo.order, tabTitle)
            mainEntryInfo.icon?.let {
                menuItem?.icon = ContextCompat.getDrawable(this, it)
            }
        }

        // set the home component
        mainEntryComp.find { it.home }?.let {
            viewBinding?.appNavBar?.selectedItemId = it.id
        }
    }
}
