package com.carvana.android.myapplication.activities

import android.os.Bundle
import android.view.Menu
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.carvana.android.common.bases.AppBaseActivity
import com.carvana.android.common.bases.AppDelegate
import com.carvana.android.common.models.AppFeature
import com.carvana.android.common.utils.AppCompPublicFace
import com.carvana.android.myapplication.R
import com.carvana.android.myapplication.databinding.ActivityMainBinding
import com.carvana.android.myapplication.utils.AppComponentProvider
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Represent the app main activity as the main navigation host to all the app components
 */
class AppMainActivity : AppBaseActivity() {

    private val appDelegate: AppDelegate by inject()

    private val viewModel: AppMainActivityViewModel by viewModel()
    private var viewBinding: ActivityMainBinding? = null

    override val navController: NavController?
        get() =  (supportFragmentManager.findFragmentById(
            R.id.app_nav_host_fragment
        ) as? NavHostFragment)?.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        AppComponentProvider.mainEntryCompPublicFaces.apply {
            inflateBottomNav(this)
            createAppNavGraph(this)

            navController?.let { viewBinding?.appNavBar?.setupWithNavController(it) }
        }

        appDelegate.mainAppNavFlow.observe(this) {
            onMainEntryCompoNav(it)
        }
    }

    private fun createAppNavGraph(mainEntryComps: List<AppCompPublicFace>) {
        val loadedNavController = navController

        // inflating app main navigation graph
        val mainNavGraph = loadedNavController?.navInflater?.inflate(R.navigation.main_nav_graph)

        mainEntryComps.mapNotNull { it.getDetails().mainEntry }.map { mainEntryInfo ->
            // inflate component nav graph
            loadedNavController?.navInflater?.inflate(
                mainEntryInfo.navGraph
            )?.let { nestedNavGraph ->
                mainNavGraph?.apply {
                    // add component nav graph into app main nav
                    addAll(nestedNavGraph)

                    // if true, inflated component nav graph is home
                    if (mainEntryInfo.home) {
                        setStartDestination(nestedNavGraph.startDestinationId)
                    }
                }
            }
        }

        mainNavGraph?.let { loadedNavController.graph = it }
    }

    /**
     * Inflates the bottom navigator menu out of the main entry components
     */
    private fun inflateBottomNav(mainEntryComps: List<AppCompPublicFace>) {
        // holds the main components entry information
        val mainEntries = mainEntryComps.mapNotNull { it.getDetails().mainEntry }
        val navInflater = navController?.navInflater

        val menu = viewBinding?.appNavBar?.menu
        mainEntries.forEach { mainEntryInfo ->
            val tabTitle = getString(mainEntryInfo.label)

            // generate the bottomNav MenuItem Id from the main entry component navGraph start Dest
            // this is to be in compliance with navigation component principles
            val menuId = navInflater?.inflate(mainEntryInfo.navGraph)?.startDestinationId
                ?: throw IllegalStateException(
                    "Couldn't generate MenuItem Id for $tabTitle BottomNav Tab"
                )

            // important Menu.CATEGORY_SECONDARY should be used all the time to keep
            // fragment multi-stack alive
            val menuItem = menu?.add(
                Menu.CATEGORY_SECONDARY, menuId, mainEntryInfo.order, tabTitle
            )
            mainEntryInfo.icon?.let {
                menuItem?.icon = ContextCompat.getDrawable(this, it)
            }

            if (mainEntryInfo.home) {
                viewBinding?.appNavBar?.selectedItemId = menuId
            }
        }
    }

    /**
     * Handles navigation into components that participate into the app main entries
     */
    private fun onMainEntryCompoNav(feature: AppFeature) {
        val componentType = AppComponentProvider.mainEntryCompPublicFaces.map {
            it.getDetails().type
        }.find { feature in it.features }

        val component = componentType?.let { AppComponentProvider.getOrInflateComp(it, getKoin()) }
        val componentGraph = component?.getDetails()?.mainEntry?.navGraph?.let {
            navController?.navInflater?.inflate(it)
        }
        val tabId = componentGraph?.startDestinationId
        tabId?.let { viewBinding?.appNavBar?.selectedItemId = it }
    }
}
